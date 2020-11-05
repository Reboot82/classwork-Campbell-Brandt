function startGame(){

    $.ajax( {
        url: 'http://localhost:8080/api/begin',
        method: 'POST',
        success: function( id ){

            loadGame( id );


        }
    } );

}

function loadGame( id ){

    $.ajax( {
        url: 'http://localhost:8080/api/gamestate/' + id,
        method: 'GET',
        success: function( data ){
            loadBoard( data );

        }
    });

}

function loadBoard( board ){

    }

function submitGuess(){


}