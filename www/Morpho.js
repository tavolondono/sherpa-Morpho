var morpho = {
    getRegard: function(successCallback, errorCallback, title) {
        cordova.exec(
            successCallback, // success callback function
            errorCallback, // error callback function
            'Morpho', // mapped to our native Java class called "CalendarPlugin"
            'getRegard', // with this action name
            [{                  // and this array of custom arguments to create our entry
                "title": title
            }]
        ); 
    }
};
module.exports = morpho;