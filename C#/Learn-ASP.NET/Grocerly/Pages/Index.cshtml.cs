﻿@page
@model IndexModel
@{
  ViewData["Title"] = "Home";
}

< div class= "text-center" >
  < h1 id = "store-name" >< img id = "green-cart" class= "mr-2" src = "https://content.codecademy.com/courses/asp-dot-net/food_icons/cart-green.png" > Grocer.ly </ h1 >
  < p > Browse our inventory online and shop in-store!</p>
</div>

<div id="food-container">
  <!-- Loop through Model.Foods -->
  @foreach (var food in Model.Foods)
  {
    <div class= "food-item pb-2 pt-2 row align-items-center" >
    < div class= "col-3 pl-1 pr-1 text-center" id = "image-col" >
      < img class= "food-item-image" src = @food.ImageSrc alt = @food.Name >
    </ div >
    < div class= "col-6 pl-1 pr-1" id = "info-col" >
      < p class= "food-item-info" > @food.Name </ p >
      < p class= "food-item-info" > $@String.Format("{0:0.00} / lb", food.Price) </ p >
    </ div >
    < div class= "col-3 pl-1 pr-1 text-center" id = "button-col" >
      < a asp - page = "/Details" asp - route - name = @System.Web.HttpUtility.UrlPathEncode(food.Name) class= "btn text-white" > More info </ a >
    </ div >
    </ div >
  }
</ div >

< hr class= "mt-2" />

