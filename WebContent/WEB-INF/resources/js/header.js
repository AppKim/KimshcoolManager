/**
 * 
 */

function bold(){
    $( document ).ready( function() {
        $("img")
          .mouseover( function() { 
            $(this).attr( 'src', 'rollover-image-2.png' );
          } )
          .mouseout( function() {
            $(this).attr( 'src', 'rollover-image-1.png' );
          } );
      } );
}