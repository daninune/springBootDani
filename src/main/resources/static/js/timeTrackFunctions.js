/*
 * Common Tracking functions used in both sites employee and admin.
 */

/*
function showTimeTrackingCalendar(x, idemployee) {
    var dataString = "date=" + x + "&idEmployee=" + idemployee;
    $.ajax({
        type: "POST",
        url: window.site_url + "timetrack/getTimeTrackingCalendar",
        data: dataString,
        cache: false,
        success: function (html) {
            $("#timetrackDiv").html(html);
        },
    });
}

function showTimeTrackingCalendarAdmin(x, idemployee) {

    var dataString = "date=" + x + "&idEmployee=" + idemployee;
    $.ajax({
        type: "POST",
        url: window.site_url + "timetrack/getTimeTrackingCalendar",
        data: dataString,
        cache: false,
        success: function (html) {
            $("#timetrackDivAdmin").html(html);
        },
    });
}

function getTimeTracking(x, idEmployee) {
    let dat;
    dat = x.split(',');
    if (dat[0] != null) {
        var dataString = "date=" + dat[0] + "&idEmployee=" + idEmployee;
        $.ajax({
            type: "POST",
            url: window.site_url + "Timetrack/getTimeTracking",
            data: dataString,
            cache: false,
            success: function (html) {
                $("#timetrackDiv").html(html);
            },
        });
    } else {
        var dataString = "date=" + x + "&idEmployee=" + idEmployee;
        $.ajax({
            type: "POST",
            url: window.site_url + "timetrack/getTimeTracking",
            data: dataString,
            cache: false,
            success: function (html) {
                $("#timetrackDiv").html(html);
            },
        });
    }

}

function getTimeTrackingAdmin(x, hash) {
    $.ajax({
        type: "POST",
        url: window.site_url + "timetrack/getTimeTrackingAdmin",
        data: {date: x, hash: hash},
        success: function (html) {
            $("#timetrackDivAdmin").html(html);
        },
    });
}

//Se utiliza para obtener la semana anterior o posterior dentro del registro de horas del empleado
function getTimeTrackingAdmin2(date, idEmployee) {
    var dataString = "date=" + date + "&idEmployee=" + idEmployee;

    $.ajax({
        type: "POST",
        url: window.site_url + "timetrack/getTimeTracking",
        data: dataString,
        cache: false,
        success: function (html) {
            $("#timetrackDivAdmin").html(html);
        },
    });
}

function replicatePrevWeek(previousWeek) {
    const dataSend = {dataWeek: previousWeek};
    const prevDate = new Date(previousWeek[0]['date']);
    const currentDate = prevDate.setDate(prevDate.getDate() + 7);
    const date = moment(new Date(currentDate)).format('YYYYMMDD');
    const idemployee = previousWeek[0]['idemployee'];

    $.post(window.site_url + "timetrack/setReplicateWeek", dataSend).done(
        function (msg) {
            if (msg == "Datos guardados correctamente") {
                getTimeTracking(date, idemployee);
                $('#entry-modal').modal('hide');
            } else {
                alert(msg);
                getTimeTracking(date, idemployee);
                $('#entry-modal').modal('hide');
            }

        }
    );
}*/
function test(id) {
    let msg = "Este es el id pasado: " + id;
    alert(msg);
}


// Handle click on datePeriod checkbox
function showDateEnd() {

    // Date format
    const formatYmd = date => date.toISOString().slice(0, 10);

    var dateEnd = document.getElementById("dateEndDiv");
    var period = document.getElementById("datePeriod");

    if (period.checked) {
        document.getElementById('dateEnd').value = formatYmd(new Date());

        dateEnd.style.display = "block";

    } else {
        document.getElementById('dateEnd').value = "";
        dateEnd.style.display = "none";
    }
}

//muestra si chekeamos en horario partido
//dos entradas mas de hora
function showHourShift() {
    var timeInit = document.getElementById("timeInitContainerShift");
    var timeEnd = document.getElementById("timeEndContainerShift");
    var shift = document.getElementById("splitShift");
    if (shift.checked) {
        timeInit.style.display = "block";
        timeEnd.style.display = "block"
    } else {
        timeInit.style.display = "none";
        timeEnd.style.display = "none";
    }
}

// Open the entry-modal and load the data
function editEntry(id, date, description, projectName, timeInit, timeEnd, ubication, extraHour) {
    document.getElementById('entryId').value = id;
    document.getElementById('descriptionModal').value = description;

    var projects = document.getElementById('idProjectModal');
    projects.selectedIndex = 0;

    for (var i = 0; i < projects.options.length; i++) {
        if (projects.options[i].text == projectName) {
            projects.selectedIndex = i;
        }
    }

    // Check if the Project is computable
    var computable;

    var dataString = "projectId=" + projects.value;

    $.ajax({
        type: "POST",
        url: window.site_url + "Projects/getIsComputable",
        data: dataString,
        cache: false,
        success: function (result) {

            if (!result) {
                document.getElementById("idUbication").style.display = "none";
                document.getElementById("idUbication").value = "0";
                document.getElementById("timeInitContainerModal").style.display = "none";
                document.getElementById("timeInitModal").value = "00:00";
                document.getElementById("timeEndContainerModal").style.display = "none";
                document.getElementById("timeEndModal").value = "00:00";
                document.getElementById("extraHoursContainerModal").style.display = "none";
            } else {
                document.getElementById("idUbication").style.display = "block";
                document.getElementById("timeInitContainerModal").style.display = "block";
                document.getElementById("timeEndContainerModal").style.display = "block";
                document.getElementById("extraHoursContainerModal").style.display = "block";
            }
        }
    });

    // Date and Time
    document.getElementById('dateModal').value = date;
    document.getElementById('timeInitModal').value = timeInit;
    document.getElementById('timeEndModal').value = timeEnd;

    // Ubication
    if (ubication == "Oficina") {
        document.getElementById("officeModal").checked = true;
    } else if (ubication == "Teletrabajo") {
        document.getElementById("remoteModal").checked = true;
    } else {
        document.getElementById("customerModal").checked = true;
    }

    // Extra Hours
    if (extraHour == "Si") {
        document.getElementById("isExtraModal").checked = true;
    } else {
        document.getElementById("isNotExtraModal").checked = true;
    }

    // Wait to load computable result
    setTimeout(() => {
        $('#entry-modal').modal('show')
    }, 1200);
}

/*

function saveTracking(id, idemployee) {

    var id = id;
    var idemployee = idemployee;
    var description, idProject, date, dateEnd, timeInit, timeEnd, timeInitShift, timeEndShift;
    var isExtra;
    var isExtraOptions;
    var ubication;
    var ubicationOptions;
    // Period checkbox
    var period = document.getElementById("datePeriod");
    var shift = document.getElementById("splitShift");

    var control = false;

    if (id == 0) {
        // If is a new entry

        description = document.getElementById("description").value;
        idProject = document.getElementById("idProject").value;
        date = document.getElementById("date").value;
        // Check if is a period
        if (period.checked) {
            dateEnd = document.getElementById('dateEnd').value;
        }
        // Time
        timeInit = document.getElementById("timeInit").value;
        timeEnd = document.getElementById("timeEnd").value;
        if (shift.checked) {
            timeInitShift = document.getElementById("timeInitShift").value;
            timeEndShift = document.getElementById("timeEndShift").value;
        }
        // Extra Hours
        isExtraOptions = document.getElementById('extraHours');
        if (isExtraOptions.checked) {
            isExtra = 1;
        } else {
            isExtra = 0;
        }
        // Ubication
        ubication = document.getElementById("idUbication").value;

    } else {
        // If is modifying an entry

        description = document.getElementById("descriptionModal").value;
        idProject = document.getElementById("idProjectModal").value;
        date = document.getElementById("dateModal").value;
        timeInit = document.getElementById("timeInitModal").value;
        timeEnd = document.getElementById("timeEndModal").value;
        // Extra Hours
        isExtraOptions = document.getElementsByName('extraHoursModal');
        for (var i = 0; i < isExtraOptions.length; i++) {
            if (isExtraOptions[i].checked) {
                isExtra = isExtraOptions[i].value;
            }
        }
        // Ubication
        ubicationOptions = document.getElementsByName('ubicationOptionsModal');
        for (var i = 0; i < ubicationOptions.length; i++) {
            if (ubicationOptions[i].checked) {
                ubication = ubicationOptions[i].value;
            }
        }
    }
    control = inputControl(description, idProject, date, dateEnd, timeInit, timeEnd, timeInitShift, timeEndShift, isExtra, isExtraOptions, ubication, period, shift);

    let computable = true;
    if (timeInit == "00:00" && timeEnd == "00:00") {
        computable = false;
    }
    var startTime = new Date();
    startTime.setHours(timeInit.substring(0, 2), timeInit.substring(3, 5), 00);
    var endTime = new Date();
    if (timeEnd == '00:00' && computable) {
        timeEnd = '24:00';
    } else {
        endTime.setHours(timeEnd.substring(0, 2), timeEnd.substring(3, 5), 00);
    }

    if (control) {
        var data = {
            id,
            idemployee,
            description,
            idProject,
            date,
            dateEnd,
            timeInit,
            timeEnd,
            timeInitShift,
            timeEndShift,
            isExtra,
            ubication
        };
        const dataSend = JSON.stringify(data);
        $.post(window.site_url + "timetrack/setTimeTracking", dataSend).done(
            function (msg) {
                if (msg == "Datos guardados correctamente") {
                    alert(msg);
                    location.reload();
                    $('#entry-modal').modal('hide');
                } else {
                    alert(msg);
                    location.reload();
                    $('#entry-modal').modal('hide');
                }
            }
        );
    }
}

function inputControl(description, idProject, date, dateEnd, timeInit, timeEnd, timeInitShift, timeEndShift, isExtra, isExtraOptions, ubication, period, shift) {
    // Regex for time
    var regexTime = new RegExp("^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$");

    if (description == "") {
        alert("Debes introducir una descripción");
    } else if (idProject == "null") {
        alert("Debe de seleccionar un proyecto");
    } else if (ubication == "null") {
        alert("Debe de seleccionar un lugar de trabajo");
    } else if (date == "") {
        alert("Debe de introducir una fecha");
    } else if (period.checked && new Date(date) >= new Date(dateEnd)) {
        alert("La fecha de inicio no puede ser menor o igual que la fecha fin");
    } else if (timeInit == "") {
        alert("Debe de introducir una hora de inicio");
    } else if (!regexTime.test(timeInit)) {
        alert("El formato de la hora de inicio no es válido");
    } else if (timeEnd == "") {
        alert("Debe de introducir una hora de fin");
    } else if (!regexTime.test(timeEnd)) {
        alert("El formato de la hora de fin no es válido");
    } else if (shift.checked && !regexTime.test(timeInitShift)) {//añadido
        alert("El formato de la segunda hora de inicio no es válido");
    } else if (shift.checked && !regexTime.test(timeEndShift)) {//añadido
        alert("El formato de la segunda hora de fin no es válido");
    } else {
        var computable = true;
        if (timeInit == "00:00" && timeEnd == "00:00") {
            computable = false;
        }
        var startTime = new Date();
        startTime.setHours(timeInit.substring(0, 2), timeInit.substring(3, 5), 00);
        var endTime = new Date();
        if (timeEnd == '00:00' && computable) {
            timeEnd = '24:00';
        } else {
            endTime.setHours(timeEnd.substring(0, 2), timeEnd.substring(3, 5), 00);
        }

        if ((startTime > endTime || timeInitShift > timeEndShift || timeEnd > timeInitShift) && timeEnd != '24:00' && computable) {
            alert("Hay un error en las horas.\nIntroduce una franja horaria razonable");
        } else {
            return true
        }
    }
}


// Add a new entry row to an existing date table
function addNewRow(id, date, description, projectName, timeInit, timeEnd, ubication, extraHour, idemployee, admin) {

    var arrayData = ["'" + id + "'", "'" + date + "'", "'" + description + "'", "'" + projectName + "'", "'" + timeInit + "'", "'" + timeEnd + "'", "'" + ubication + "'", "'" + extraHour + "'"];
    var arrayDelete = ["'" + id + "'", "'" + date + "'", "'" + idemployee + "'"];

    var table = document.getElementById(date).getElementsByTagName('tbody')[0];

    if (admin == true) {
        table.insertRow().innerHTML =
            '<tr><td>' + description + '</td><td>' + projectName + '</td><td>' + timeInit + ' - ' + timeEnd + '</td><td>' + ubication + '</td><td>' + extraHour + '</td></tr>';

    } else {
        table.insertRow().innerHTML =
            '<tr><td>' + description + '</td><td>' + projectName + '</td><td>' + timeInit + ' - ' + timeEnd + '</td><td>' + ubication + '</td><td>' + extraHour + '</td><td width="5%"><a id="edit" style="cursor: pointer;" onclick="editEntry(' + arrayData + ')"><img src="' + window.site_url + 'img/pencil.png' + '" class="iconic - sprite" /></a></td><td width="5%"><a id="delete" style="cursor: pointer;" onclick="deleteEntry(' + arrayDelete + ')"><img src="' + window.site_url + 'img/bin.png' + '" class="iconic - sprite" /></a></td></tr>';
    }

}


// Open the entry-modal and load the data
function editEntry(id, date, description, projectName, timeInit, timeEnd, ubication, extraHour) {
    document.getElementById('entryId').value = id;
    document.getElementById('descriptionModal').value = description;

    var projects = document.getElementById('idProjectModal');
    projects.selectedIndex = 0;

    for (var i = 0; i < projects.options.length; i++) {
        if (projects.options[i].text == projectName) {
            projects.selectedIndex = i;
        }
    }

    // Check if the Project is computable
    var computable;

    var dataString = "projectId=" + projects.value;

    $.ajax({
        type: "POST",
        url: window.site_url + "Projects/getIsComputable",
        data: dataString,
        cache: false,
        success: function (result) {

            if (!result) {
                document.getElementById("idUbication").style.display = "none";
                document.getElementById("idUbication").value = "0";
                document.getElementById("timeInitContainerModal").style.display = "none";
                document.getElementById("timeInitModal").value = "00:00";
                document.getElementById("timeEndContainerModal").style.display = "none";
                document.getElementById("timeEndModal").value = "00:00";
                document.getElementById("extraHoursContainerModal").style.display = "none";
            } else {
                document.getElementById("idUbication").style.display = "block";
                document.getElementById("timeInitContainerModal").style.display = "block";
                document.getElementById("timeEndContainerModal").style.display = "block";
                document.getElementById("extraHoursContainerModal").style.display = "block";
            }
        }
    });

    // Date and Time
    document.getElementById('dateModal').value = date;
    document.getElementById('timeInitModal').value = timeInit;
    document.getElementById('timeEndModal').value = timeEnd;

    // Ubication
    if (ubication == "Oficina") {
        document.getElementById("officeModal").checked = true;
    } else if (ubication == "Teletrabajo") {
        document.getElementById("remoteModal").checked = true;
    } else {
        document.getElementById("customerModal").checked = true;
    }

    // Extra Hours
    if (extraHour == "Si") {
        document.getElementById("isExtraModal").checked = true;
    } else {
        document.getElementById("isNotExtraModal").checked = true;
    }

    // Wait to load computable result
    setTimeout(() => {
        $('#entry-modal').modal('show')
    }, 1200);
}


// Delete Entry
function deleteEntry(id, date, idemployee) {

    var r = confirm("¿Está seguro de borrar este registro?");

    if (r == true) {

        const data = {
            entryId: id,
            entryDate: date,
            idEmployee: idemployee
        };

        $.post(window.site_url + "timetrack/deleteTimetrack", data).done(
            function () {
                location.reload();
            }
        );
    }
}





// Handle if the Project is computable
function checkIsComputable(projectsArray, type) {

    const arrayProjects = JSON.parse(JSON.stringify(projectsArray));
    var project, projectSelected;

    // New entry
    if (type == 0) {
        projectSelected = document.getElementById("idProject");
        arrayProjects.forEach(element => {
            if (element.idProject == projectSelected.value) {
                project = element;
            }
        });


        if (project.computable == 0 || project.idProject == 81 || project.idProject == 109 || project.idProject == 117) {

            document.getElementById("idUbication").style.display = "none";
            document.getElementById("idUbication").value = "0";

            document.getElementById("timeInitContainer").style.display = "none";
            document.getElementById("timeInit").value = "00:00";

            document.getElementById("timeEndContainer").style.display = "none";
            document.getElementById("timeEnd").value = "00:00";

            document.getElementById("timeInitContainerShift").style.display = "none";
            document.getElementById("timeInitShift").value = "00:00";

            document.getElementById("timeEndContainerShift").style.display = "none";
            document.getElementById("timeEndShift").value = "00:00";

            document.getElementById("splitShiftContainer").style.display = "none";
            document.getElementById('splitShift').checked = false;

            document.getElementById("extraHoursContainer").style.display = "none";
            document.getElementById('extraHours').checked = false;
        } else {
            document.getElementById("idUbication").style.display = "block";
            document.getElementById("timeInitContainer").style.display = "block";
            document.getElementById("timeEndContainer").style.display = "block";
            document.getElementById("splitShiftContainer").style.display = "block";
            document.getElementById("extraHoursContainer").style.display = "block";
        }
    }


    // Edit entry
    else {
        projectSelected = document.getElementById("idProjectModal");
        arrayProjects.forEach(element => {
            if (element.idProject == projectSelected.value) {
                project = element;
            }
        });


        if (project.computable == 0 || project.idProject == 81 || project.idProject == 109 || project.idProject == 117) {

            document.getElementById("idUbication").style.display = "none";
            document.getElementById("idUbication").value = "0";
            document.getElementById("timeInitContainerModal").style.display = "none";
            document.getElementById("timeInitModal").value = "00:00";
            document.getElementById("timeEndContainerModal").style.display = "none";
            document.getElementById("timeEndModal").value = "00:00";
            document.getElementById("extraHoursContainerModal").style.display = "none";
        } else {
            document.getElementById("idUbication").style.display = "block";
            document.getElementById("timeInitContainerModal").style.display = "block";
            document.getElementById("timeEndContainerModal").style.display = "block";
            document.getElementById("extraHoursContainerModal").style.display = "block";
        }
    }
}

var arrSelectedDates = [];
var publicHolidays = [];
var vacations = [];
var colors = [];
var currentCalendarYear;


$(document).ready(function () {
    /!*Calendario de timetrack para proyectos comunes no computables, se muestra solo para superadmin*!/

    $.fn.overflown = function () {
        var e = this[0];
        return e.scrollHeight > e.clientHeight || e.scrollWidth > e.clientWidth;
    }

    $('#calendarTimeTracking').hide();

    $('#calendarTimeTracking').calendar({

        minDate: getMinDate2(),
        maxDate: getMaxDate2(),
        language: 'es',
        weekStart: 1,
        enableContextMenu: false,
        enableRangeSelection: false,


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
        dataSource: []
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


function showTimeTrackingCalendarCommon() {
    const btn = document.getElementById("calendar-btn");

    if (btn.textContent == "Abrir Calendario") {
        btn.textContent = "Cerrar Calendario";
        $("#addButton").hide();
        $("#addButtonNoComp").show();

        $('#calendarTimeTracking').show();

        document.getElementById("idProject").style.display = "none";
        document.getElementById("nonComputableCommonProjects").style.display = "block";

        document.getElementById("dateContainer").style.display = "none";

        document.getElementById("idUbication").style.display = "none";
        document.getElementById("idUbication").value = "0";

        document.getElementById("timeInitContainer").style.display = "none";
        document.getElementById("timeInit").value = "00:00";

        document.getElementById("timeEndContainer").style.display = "none";
        document.getElementById("timeEnd").value = "00:00";

        document.getElementById("timeInitContainerShift").style.display = "none";
        document.getElementById("timeInitShift").value = "00:00";

        document.getElementById("timeEndContainerShift").style.display = "none";
        document.getElementById("timeEndShift").value = "00:00";

        document.getElementById("periodContainer").style.display = "none";
        document.getElementById('datePeriod').checked = false;

        document.getElementById("splitShiftContainer").style.display = "none";
        document.getElementById('splitShift').checked = false;

        document.getElementById("extraHoursContainer").style.display = "none";
        document.getElementById('extraHours').checked = false;

    } else {
        btn.textContent = "Abrir Calendario";
        $("#addButton").show();
        $("#addButtonNoComp").hide();


        $('#calendarTimeTracking').hide();

        document.getElementById("idProject").style.display = "block";
        document.getElementById("nonComputableCommonProjects").style.display = "none";

        document.getElementById("dateContainer").style.display = "block";

        document.getElementById("idUbication").style.display = "block";

        document.getElementById("timeInitContainer").style.display = "block";

        document.getElementById("timeEndContainer").style.display = "block";

        document.getElementById("periodContainer").style.display = "block";

        document.getElementById("splitShiftContainer").style.display = "block";

        document.getElementById("extraHoursContainer").style.display = "block";

    }

}

function saveTrackingCalendar(idEmployee) {
    var description = document.getElementById("description").value;
    var idProject = document.getElementById("nonComputableCommonProjects").value;
    arrSelectedDates.sort((a, b) => new Date(a) - new Date(b));

    if (description == "") {
        alert("Debes introducir una descripción");
    } else if (idProject == "null") {
        alert("Debe de seleccionar un proyecto");
    } else {

        var data = {
            idEmployee,
            description,
            idProject,
            arrSelectedDates
        };

        const dataSend = JSON.stringify(data);
        $.post(window.site_url + "timetrack/setTimeTrackingCalendar", dataSend).done(
            function (msg) {
                alert(msg);
                location.reload();
            }
        );
    }
}
*/
