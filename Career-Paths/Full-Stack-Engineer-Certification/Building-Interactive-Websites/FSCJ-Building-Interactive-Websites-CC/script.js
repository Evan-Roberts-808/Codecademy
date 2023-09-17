// Click handler for search button
const captureSearchValue = () => {
    // Get the search bar input element
    const searchInput = document.getElementById("search-bar");
    
    // Return the value of the input
    return searchInput.value;
  };
  
  // Filter books based on search input and render filtered books to the DOM
  const filterBooks = (searchValue, books) => {
    // Use the flattenObjectValuesIntoArray helper function to search all fields
    const flattenedBooks = flattenObjectValuesIntoArray(books);
  
    // Filter books that match the searchValue
    const filteredBooks = books.filter((book) => {
      const bookValues = flattenObjectValuesIntoArray([book]);
      return bookValues.some((value) => value.includes(searchValue));
    });
  
    return filteredBooks;
  };
  
  // Empty the book list container, iterate over list of filtered books,
  // return list of books formatted as HTML using the function in `helper.js`
  const structureBooksAsHtml = (filteredBooks) => {
    const formattedBooks = filteredBooks.map((book) => {
      return structureBookAsHtml(book);
    });
    
    return formattedBooks;
  };
  
  // Handler triggered when a user clicks the "Search" button. Chains previously defined
  // functions together to filter books based on the search value, format the books as HTML,
  // and render them to the DOM
  const searchBtnClickHandler = (books) => {
    // Capture the search value
    const searchValue = captureSearchValue();
    
    // Filter books based on the search value
    const filteredBooks = filterBooks(searchValue, books);
    
    // Structure filtered books as HTML
    const formattedBooks = structureBooksAsHtml(filteredBooks);
    
    // Render the formatted books to the DOM
    renderBooksToDom(formattedBooks);
  };
  
  // Grab search button from the DOM
  const searchBtn = document.getElementById("search-btn");
  
  // Attach an event listener to the search button
  searchBtn.addEventListener("click", () => { searchBtnClickHandler(books) });