$(document).ready(function() {
    setBMITextColor("#bmi");
    setBMITextColor("#obesity");
});

function setBMITextColor(id){
	var obesityResult = $("#obesity").text().trim();

    switch(obesityResult) {
        case "痩せ型":
            $(id).css("color", "blue");
            break;
        case "標準":
            $(id).css("color", "green");
            break;
        case "肥満":
            $(id).css("color", "red");
            break;
        default:
            $(id).css("color", "black");
            break;
    }
}