const express = require('express');
const app = express();
const fs = require('fs');

const csv = require('fast-csv');

const orders = []

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

app.get('/dish/:dishType', function (req, res) {
  const dishType = req.params.dishType
  const ordersByDishType = orders.filter(dish => dish.dish_type === dishType)
  res.send(ordersByDishType);
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});

