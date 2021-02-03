console.log("Hello showtime");
$(document).ready( function(){
    $('#timeLink').click(function(){
        console.log("showtime click function");
        $('#time').load(this.href); return false;
    });
});