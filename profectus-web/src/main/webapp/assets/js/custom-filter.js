$.fn.dataTableExt.afnFiltering.push(
   function( oSettings, aData, iDataIndex ) {
      var chosenName = $("#messageName").val(); // Grab selected item in the dropdown list
      var nameInColumn = aData[0]; // 2 is the index (begins from 0) of the column I want to sort
       
      // If nothing or "All" is selected, don't filter
      if ( chosenName == "" )
      {
         return true;
      }
      // Filtering on the city name
      else if ( chosenName == nameInColumn)
      {
         return true;
      }
      return false;
   }
);
 
// Redraw the table as soon as the selected item changes
// Important : the DataTable is accessible through the taglib with the name : oTable_[HTML table id]
$("#messageName").change( function() { oTable_myTableId.fnDraw(); });