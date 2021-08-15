var listAccount = [];
var listDepartment = [];
var listPossition = [];

$(function () {
    getListEmployees();
    getListDepartment();
    getListPossition();
    $('#Cretate_Date_ID').attr('disabled', 'disabled')
    $('#ID_ID').attr('disabled', 'disabled')

    $('#main_form_id').submit(function () {

        for (let index = 0; index < listDepartment.length; index++) {
            if (listDepartment[index].name == $('#department_Select_id').val()) {
                var depID = listDepartment[index].id
            }
        }
        for (let index = 0; index < listPossition.length; index++) {
            if (listPossition[index].name == $('#position_Select_id').val()) {
                var posID = listPossition[index].id
            }
        }
        var account = {
            // 'Email': $('#ememail').val(),
            // 'Username': $('#emusername').val(),
            // 'FullName': $('#emfullname').val(),
            // 'Department': $('#department_Select_id').val(),
            // 'Position': $('#position_Select_id').val(),

            'email': $('#ememail').val(),
            'username': $('#emusername').val(),
            'fullname': $('#emfullname').val(),
            'departmentId': depID,
            'positionId': posID,
            // 'CreateDate': $('#emdate').val()
        }
        // var f_ID = $('#emid').val()
        // var f_Email = $('#ememail').val()
        // var f_Username = $('#emusername').val()
        // var f_Fullname = $('#emfullname').val()
        // var f_Department_ID = $('#department_Select_id').val()
        // var f_Possition_ID = $('#position_Select_id').val()
        // var f_Date = $('#emdate').val()


        $.post("http://localhost:8080/api/v1/accounts/", account,
            function (data, status) {
                if (status == "error") {
                    alert("Error when loading date");
                    return;
                }
                getListEmployees();
            });
        return false;
    });

})

function showAccount() {
    $('#tbody_tb').empty()
    for (var index = 0; index < listAccount.length; index++) {
        $('#tbody_tb').append(`
            <tr>
            <th>${listAccount[index].AccountID}</th>
            <th>${listAccount[index].Email}</th>
            <th>${listAccount[index].Username}</th>
            <th>${listAccount[index].FullName}</th>
            <th>${listAccount[index].Department}</th>
            <th>${listAccount[index].Position}</th>
            <th>${listAccount[index].CreateDate}</th>
            <th><button class="btn btn-warning" onclick="updateAccount(${index})">Edit</button></th>
            <th><button class="btn btnwarning" onclick="deleteAccount(${index})">Delete</button></th>
            </tr>
        `)
    }
}
function deleteAccount(Index) {
    var deltete_ID = listAccount[Index].AccountID;
    var confirm_delete = confirm('Chắc chắn xóa nhé?');
    if (confirm_delete) {
        $.ajax({
            url: 'http://localhost:8080/api/v1/accounts/' + $('#emid').val(),
            type: 'DELETE',
            success: function (result) {
                if (result == undefined || result == null) {
                    alert('error when downloading');
                    return;
                }
                getListEmployees();
            }
        })
    } else return;
}
function updateAccount(Index) {
    $('#emid').attr('disabled', 'disabled')
    $('#emusername').attr('disabled', 'disabled')
    $('#emdate').attr('disabled', 'disabled')

    $('#emid').val(listAccount[Index].AccountID)
    $('#ememail').val(listAccount[Index].Email)
    $('#emusername').val(listAccount[Index].Username)
    $('#emfullname').val(listAccount[Index].FullName)
    $('#department_Select_id').val(listAccount[Index].Department)
    $('#position_Select_id').val(listAccount[Index].Position)
    $('#emdate').val(listAccount[Index].CreateDate)

    $('#emid').focus()

    $('#Main_Form_Update').click(function () {
        for (let index = 0; index < listDepartment.length; index++) {
            if (listDepartment[index].name == $('#department_Select_id').val()) {
                var depID = listDepartment[index].id
            }
        }
        for (let index = 0; index < listPossition.length; index++) {
            if (listPossition[index].name == $('#position_Select_id').val()) {
                var posID = listPossition[index].id
            }
        }

        var account = {
            'fullname': $('#emfullname').val(),
            'departmentId': depID,
            'positionId': posID,
        }

        $.ajax({
            url: 'http://localhost:8080/api/v1/accounts/' + $('#emid').val(),
            type: 'PUT',
            data: account,
            success: function (result) {
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }
                getListEmployees();
            }
        });
    })
}

function getListEmployees() {
    $.get("http://localhost:8080/api/v1/accounts/", function (data, status) {
        listAccount = [];

        if (status == "error") {
            alert("Error when loading data")
            return;
        }
        parseData(data);
        showAccount();
    });
}

function parseData(data) {
    data.content.forEach(
        function (item) {
            var account = {
                'AccountID': item.id,
                'Email': item.email,
                'Username': item.username,
                'FullName': item.fullname,
                'Department': item.department,
                'Position': item.position,
                'CreateDate': item.createDate,
            }
            listAccount.push(account)
        }
    )
}

function getListDepartment() {
    $.get("http://localhost:8080/api/v1/departments/", function (data, status) {
        listDepartment = [];

        if (status == "error") {
            alert("Error when loading data department");
            return;
        }
        data.forEach(function (item) {
            var department = {
                'id': item.id,
                'name': item.name,
            }
            listDepartment.push(department);
        });
        for (let index = 0; index < listDepartment.length; index++) {
            $('#department_Select_id').append(`
                <option>${listDepartment[index].name}</option>
            `)
        }
    });
}

function getListPossition() {
    $.get("http://localhost:8080/api/v1/positions/", function (data, status) {
        listPossition = [];

        if (status == "error") {
            alert("Error when loading data possitions");
            return;
        }
        data.forEach(function (item) {
            var possition = {
                'id': item.id,
                'name': item.name,
            }
            listPossition.push(possition);
        });
        for (let index = 0; index < listPossition.length; index++) {
            $('#position_Select_id').append(`
            <option>${listPossition[index].name}</option>
            `)
        }
    });
}