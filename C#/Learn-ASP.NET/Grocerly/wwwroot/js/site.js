// Please see documentation at https://docs.microsoft.com/aspnet/core/client-side/bundling-and-minification
// for details on configuring this project to bundle and minify static web assets.

// Write your Javascript code.
var $totalPrice = $('#total-price');
var $quantity = $('#quantity');
var $unitPrice = $('#unit-price')
var unitPrice;
var currentQuantity;

// Executes if #total-value element is on current page
if ($totalPrice.length > 0)
{
  $quantity.on('change', (event) => {
    currentQuantity = parseInt($quantity.val());
    unitPrice = Number($unitPrice.text());

    // For debugging
    // console.log('currentQuantity: ' + currentQuantity);
    // console.log('price: ' + unitPrice);
    var totalPrice = unitPrice * currentQuantity
    $totalPrice.text(totalPrice.toFixed(2));
  });
}