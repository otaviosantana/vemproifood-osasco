const express = require('express');
const app = express();
const fs = require('fs');

const csv = require('fast-csv');

const orders = []
const restaurants = []

csv
  .fromPath('../../../orders.csv')
  .on('data', data => {
    const [ order_id, dish_type, dish, order_value ] = data[0].split(';')
    
    if (order_id === 'order_id') return true;
    
    orders.push({
      order_id, dish_type, dish, order_value
    })
  })
  .on('end', () => {
    console.log('pedidos carregados');
  });

  csv
  .fromPath('../../../restaurantes.csv')
  .on('data', data => {
    const [ restaurant, dish ] = data[0].split(';')
    
    if (restaurant === 'restaurant') return true;
    
    orders.push({
      restaurant, dish
    })
  })
  .on('end', () => {
    console.log('restaurantes carregados');
  });

app.get('/dish/:dishType', function (req, res) {
  const dishType = req.params.dishType
  const ordersByDishType = orders.filter(dish => dish.dish_type === dishType)
  res.send(ordersByDishType);
});

app.get('/restaurantByDish/:dish', function (req, res) {
  const dish = req.params.dish
  const ordersByDish = orders.filter(dish => dish.dish === dish)
  res.send(ordersByDish);
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});

