// Filters

function filterData() {

    var idProject, dateInit, dateEnd, HoursInit, HoursEnd;

    idProject = document.getElementById("filter_project").value;

    dateInit = document.getElementById("filter_dateFrom").value;
    dateEnd = document.getElementById("filter_dateTo").value;

    HoursInit = document.getElementById("filter_hoursFrom").value;
    HoursEnd = document.getElementById("filter_hoursTo").value;


    if (idProject == "null") {
        idProject = 0;
    }

    if (HoursInit == "") {
        HoursInit = -1;
    }

    if (HoursEnd == "") {
        HoursEnd = -1;
    }

    var data = {
        idProject,
        dateInit,
        dateEnd,
        HoursInit,
        HoursEnd
    };

    $.post(window.site_url + "timetrack/admin", data).done(
        function (html) {
            rows_selected = [];
            $("#TimereportDiv").html(html);
            addClickerSelectedUsersForMailing();
        }
    );

}

function clearFilter() {

    $.post(window.site_url + "timetrack/admin").done(
        function () {
            rows_selected = [];
            location.reload();
        }
    );

}


// Employees Selection

var rows_selected = [];


// Updates "Select all" control in a data table
function updateDataTableSelectAllCtrl(table) {

    var $table = table.table().node();
    var $chkbox_all = $('tbody input[type="checkbox"]', $table);
    var $chkbox_checked = $('tbody input[type="checkbox"]:checked', $table);
    var chkbox_select_all = $('thead input[name="selectAllEmployees"]', $table).get(0);

    // If none of the checkboxes are checked
    if ($chkbox_checked.length === 0) {
        chkbox_select_all.checked = false;
        if ("indeterminate" in chkbox_select_all) {
            chkbox_select_all.indeterminate = false;
        }
    }

    // If all of the checkboxes are checked
    else if ($chkbox_checked.length === $chkbox_all.length) {
        chkbox_select_all.checked = true;
        if ("indeterminate" in chkbox_select_all) {
            chkbox_select_all.indeterminate = false;
        }

    }

    // If some of the checkboxes are checked
    else {
        chkbox_select_all.checked = true;
        if ("indeterminate" in chkbox_select_all) {
            chkbox_select_all.indeterminate = true;
        }
    }

}

function addClickerSelectedUsersForMailing() {
    $('#timeReportTable tbody').on('click', 'input[type="checkbox"]', function (e) {

        var $row = $(this).closest('tr');

        var table = $('#timeReportTable').DataTable();

        // Get row data
        var data = table.row($row).data();

        // Get row ID
        var rowId = data[6];

        // Determine whether row ID is in the list of selected row IDs
        var index = $.inArray(rowId, rows_selected);

        // If checkbox is checked and row ID is not in list of selected row IDs
        if (this.checked && index === -1) {
            rows_selected.push(rowId);
        }

        // Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
        else if (!this.checked && index !== -1) {
            rows_selected.splice(index, 1);
        }

        if (this.checked) {
            $row.addClass('selected');
        } else {
            $row.removeClass('selected');
        }

        // Update state of "Select all" control
        updateDataTableSelectAllCtrl(table);

        // Prevent click event from propagating to parent
        e.stopPropagation();

    });
}

$(document).ready(function () {
// Handle click on checkbox
    addClickerSelectedUsersForMailing();
})


// Handle click on "Select all" control
$('thead input[name="selectAllEmployees"]').on('click', function (e) {

    if (this.checked) {

        $('#timeReportTable tbody input[type="checkbox"]:not(:checked)').trigger('click');

    } else {

        $('#timeReportTable tbody input[type="checkbox"]:checked').trigger('click');

    }

    // Prevent click event from propagating to parent
    e.stopPropagation();

});


// Send Mail

function sendTimeTrackingMail() {

    if (rows_selected.length == 0) {
        alert("No hay registros seleccionados");
    } else {
        var r = confirm("¿Está seguro de enviar los correos?");

        if (r == true) {
            $.ajax({
                url: window.site_url + "timetrack/sendEmail",
                encoding: "UTF-8",
                type: "POST",
                data: {employeeIds: rows_selected},
                complete: function () {
                    location.reload();
                },
                error: function () {
                    alert("Se produjo un error");
                },
            });
        }
    }

    return false;

}


// Export CSV

function exportCSV() {

    var dateStart = $("#dt1").val().replace(/\//g, "");
    var dateEnd = $("#dt2").val().replace(/\//g, "");

    var projectNums = [];

    $("input:checkbox[name=selectProjects]:checked").each(function () {
        projectNums.push($(this).val());
    });

    var dataString =
        "dateStart=" +
        dateStart +
        "&dateEnd=" +
        dateEnd +
        "&projectNums=" +
        projectNums;

    $.ajax({
        type: "POST",
        url: window.site_url + "timetrack/exportCSV",
        data: dataString,
        cache: false,
        success: function (response) {
            content = response;
            filename = "timetrack.csv";
            var a = document.createElement("a");
            a.href =
                "data:text/csv;charset=utf-8,%EF%BB%BF" + encodeURIComponent(content); //UT-8 BOM: export csv with unicode symbols
            a.download = filename;
            a.click();
        },
    });
}


// Open the timetrack-modal and load the data
function showTimeTrackingEmployee(x, hash, employeeName) {

    // Set modal title
    $("#timetrack-modal-title").html('Registro de Horas - ' + employeeName);


    // Set modal content
    var dataString = "date=" + x + "&hash=" + hash;

    $.ajax({
        type: "POST",
        url: window.site_url + "timetrack/getTimeTrackingAdmin",
        data: dataString,
        cache: false,
        success: function (html) {
            $("#timetrackEmployeeDiv").html(html);
            $('#timetrack-modal').modal('show');
        },
    });

}


$(document).ready(function () {

// DatePicker
    $(".datePicker").datepicker({
        language: 'es',
        weekStart: 1,
        format: "yyyy-mm-dd",
        todayHighlight: true,
        autoclose: true,
        orientation: "top"
    });
// Clockpicker
    $(".clockPickerPM").clockpicker({
        autoclose: true,
        placement: 'bottom',
        twelvehour: true,
    })
    $(".clockPicker").clockpicker({
        autoclose: true,
        placement: 'bottom',
    })

});
