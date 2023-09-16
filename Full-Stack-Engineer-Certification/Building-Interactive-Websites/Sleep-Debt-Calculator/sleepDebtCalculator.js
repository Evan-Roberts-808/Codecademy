const getSleepHours = day => {
    switch(day){
      case 'Monday':
        return 8;
      case 'Tuesday':
        return 7;
      case 'Wednesday':
        return 8;
      case 'Thursday':
        return 9;
      case 'Friday':
        return 6;
      case 'Saturday':
        return 10;
      case 'Sunday':
        return 8;
    }
  };
  
  const getActualSleepHours = () =>{
    return getSleepHours('Monday') +
    getSleepHours('Tuesday') +
    getSleepHours('Wednesday') +
    getSleepHours('Thursday') +
    getSleepHours('Friday') +
    getSleepHours('Saturday') +
    getSleepHours('Sunday');
  }
  
  const getIdealSleepHours = () =>{
    let idealHours = 8;
    return idealHours*7;
  }
  
  const calculateSleepDebt = () =>{
    let actualSleepHours = getActualSleepHours();
    let idealSleepHours = getIdealSleepHours();
    
    if (actualSleepHours === idealSleepHours) {
      console.log('You have got ' + actualSleepHours + ' hours of sleep this week, it is a perfect amount.');
    }
   if (actualSleepHours > idealSleepHours) {
      console.log('You got ' + (actualSleepHours - idealSleepHours) + ' hours more sleep than you needed this week.');
    }
    if (actualSleepHours < idealSleepHours) {
      console.log('You got ' + (idealSleepHours - actualSleepHours) + ' hours less sleep than you needed this week. Get some rest.');
  }
  }
  
  calculateSleepDebt();