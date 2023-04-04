$(document).ready(function () {
    /*Calendario de timetrack para proyectos comunes no computables, se muestra solo para superadmin*/

    /*$.fn.overflown = function () {
        var e = this[0];
        return e.scrollHeight > e.clientHeight || e.scrollWidth > e.clientWidth;
    }*/

    $('#calendarIndex').calendar({

        minDate: getMinDate2(),
        maxDate: getMaxDate2(),
        language: 'es',
        weekStart: 1,
        enableContextMenu: false,
        enableRangeSelection: false,
        /*

                clickDay: function (e) {
                    handleSelection2(e.date, e.element);
                },
                selectRange: function (e) {
                    //Not used as range selection is not allowed
                },
                yearChanged: function (e) {
                    e.preventRendering = true;

                    $(e.target).append('<div style="text-align:center"><img src="' + window.base_url + 'img/loading_wheel.gif" /></div>');

                    currentCalendarYear = e.currentYear;
                    getPublicHolidays2(e.currentYear);
                },

                customDayRenderer: function (element, date) {
                     var formatDate = moment(date).format('YYYY-MM-DD');
                     if (arrSelectedDates.includes(formatDate)) {
                         $(element).parent().attr("style", "background-color: lightgrey;");
                     }

                     if (publicHolidays.includes(formatDate)) {
                         $(element).css('font-weight', 'bold');
                         $(element).css('color', 'red');
                     }

                     if (vacations.includes(formatDate)) {
                         var index = vacations.indexOf(formatDate);
                         $(element).css('font-weight', 'bold');
                         $(element).css('color', colors[index]);
                     }

                },
                dataSource: []*/
    });
})


function getPublicHolidays2(myYear) {
    $.ajax({
        type: "POST",
        dataType: "json",
        url: window.site_url + "Vacations/getPublicHolidays",
        data: {year: myYear},
        success: function (response) {
            publicHolidays = [];

            for (var i = 0; i < response.length; i++) {
                publicHolidays.push(response[i].date);
            }
            populateData2(myYear);
        },
        error: function (response) {
            //alert('ERROR: getPublicHolidays');
            console.log('ERROR: getPublicHolidays');
        }
    });
}

function populateData2(myYear) {
    //Populate calendar with requested and approved vacations
    $.ajax({
        type: "POST",
        dataType: "json",
        url: window.site_url + "Vacations/getVacations",
        data: {year: myYear},
        success: function (response) {
            fetchVacations2(response, myYear);
        },
        error: function (response) {
            console.log(response);
            alert('ERROR getVacations');
        }
    });

}

//Displays vacations and timetrack on calendar
function fetchVacations2(response, myYear) {

    for (var i = 0; i < response.length; i++) {
        vacations.push(response[i].startDate);
        colors.push(response[i].color);
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: window.site_url + "timetrack/getTimetrackDates",
        data: {year: myYear},
        success: function (response) {
            var data = [];
            for (var i = 0; i < response.length; i++) {
                data.push({
                    startDate: new Date(response[i].date),
                    endDate: new Date(response[i].date),
                    color: response[i].color
                });
            }
            $('#calendarTimeTracking').data('calendar').setDataSource(data);

        },
        error: function (response) {
            console.log(response);
            alert('ERROR getTimetrackDates');
        }
    });
}

//Min date to be displayed on calendar
function getMinDate2() {
    var currentYear = new Date().getFullYear();
    return new Date('01/01/' + (currentYear));
}

//Max date to be displayed on calendar
function getMaxDate2() {
    var currentYear = new Date().getFullYear();
    return new Date('12/31/' + (currentYear));
}

//Gives or remove style to select/unselect days
function handleSelection2(dt, e) {

    if ($(e).css('box-shadow') == 'none') {
        var formattedDate = moment(dt).format('YYYY-MM-DD');
        if (arrSelectedDates.includes(formattedDate) == true) {
            var index = arrSelectedDates.indexOf(formattedDate);
            if (index > -1) {
                arrSelectedDates.splice(index, 1);
                $(e).css('background-color', '');
            }
        } else {
            arrSelectedDates.push(formattedDate);
            $(e).attr("style", "background-color: lightgrey;");
        }
    }
}
