const menu = {
    _courses: {
      appetizers: [],
      mains:  [],
      desserts: [], 
    },
      get appetizers() { 
        return this.appetizers},
      get mains() { 
        return this.mains},
      get desserts() { 
        return this.desserts},
      //get courses
             get courses() { 
                return {
                  appetizers: this._courses.appetizers,
                  mains: this._courses.mains,
                  desserts: this._courses.desserts,
      } 
     },
  
    set appetizers(appetizerIn) { 
        this.appetizers = appetizerIn},
    set mains(mainsIn) { 
        this.mains = mainsIn},
    set desserts(dessertsIn) { 
        this.desserts = dessertsIn},
    
    addDishToCourse(courseName, dishName, dishPrice) {
      const dish = {
        name: dishName,
        price: dishPrice,
      };
      this._courses[courseName].push(dish);
    },
    
    getRandomDishFromCourse(courseName) {
      const dishes = this._courses[courseName];
      const randomIndex = Math.floor(Math.random() * dishes.length);
      return dishes[randomIndex];
    },
  
    generateRandomMeal(){
      const appetizer = this.getRandomDishFromCourse('appetizers');
      const main = this.getRandomDishFromCourse('mains');
      const dessert = this.getRandomDishFromCourse('desserts');
      const totalPrice = appetizer.price + main.price + dessert.price;
      
      return `Your meal is ${appetizer.name}, ${main.name}, ${dessert.name} The price is $${totalPrice}.`;}
    
  };
  
  menu.addDishToCourse('appetizers', 'Caesar Salad', 14.25);
  menu.addDishToCourse('appetizers', 'French Onion Soup', 12.25);
  menu.addDishToCourse('appetizers', 'Shrimp Cocktail', 20.25);
  menu.addDishToCourse('mains', 'Wagyu Steak', 72.50);
  menu.addDishToCourse('mains', 'Swordfish', 50.25);
  menu.addDishToCourse('mains', 'Parmesan Chicken', 40.25);
  menu.addDishToCourse('desserts', 'Creme Brulle', 20.25);
  menu.addDishToCourse('desserts', 'Ice Cream', 14.25);
  menu.addDishToCourse('desserts', 'Chocolate Cake', 24.25);
  
  
  let meal = menu.generateRandomMeal();
  console.log(meal);