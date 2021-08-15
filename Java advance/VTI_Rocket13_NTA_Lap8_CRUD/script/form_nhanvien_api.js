var listDepartment = []
var listPosition = []
var currentPage = 1;
var totalPages;
var size = 5;

$(function () {
    getListDepartment();
    getListPossition();
    getListEmployees();

    $('#emid').attr('disabled', 'disabled')
    $('#emdate').attr('disabled', 'disabled')
});

function getListDepartment() {
    $.get("http://localhost:8080/api/v1/departments", function (data, status) {

        listDepartment = [];
        if (status == "error") {
            alert("error loading date");
            return;
        }
        data.forEach(function (item) {
            var department = {
                'id': item.id,
                'name': item.name,
            }
            listDepartment.push(department)
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

        listPosition = [];
        if (status == "error") {
            alert("error loading date");
            return;
        }
        data.forEach(function (item) {
            var position = {
                'id': item.id,
                'name': item.name,
            }
            listPosition.push(position)
        });
        for (let index = 0; index < listPosition.length; index++) {
            $('#position_Select_id').append(`
        <option>${listPosition[index].name}</option>
        `)
        }
    });
}


function parseData(data) {
    // employees = data;
    data.content.forEach(function (item) {
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
    });
}

function showAccount() {
    $('#ememail').removeAttr("disabled")
    $('#emusername').removeAttr("disabled")
    // Xóa hết kết quả đang hiển thị ở bảng kết quả
    $('#tbody_tb').empty()
    // Lặp trong listAccount để in thông tin từng phần tử
    // Hiển thị thêm 2 nút để sửa và xóa các Account
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
    <th><button class="btn btn-warning" onclick="editAccount(${index})">Edit</button></th>
    <th><button class="btn btn-warning" onclick="deleteAccount(${index})">Delete</button></th>
    </tr>
    `)
    }
}
function getListEmployees() {

    var url = "http://localhost:8080/api/v1/accounts/?page=" + currentPage + "&size=" + size;
    
    var search = $('#input-search-department').val();

    if (search) {
        url += "&search=" + search;
    }

    // call API from server
    $.get(url, function (data, status) {
        // reset list employees
        listAccount = [];
        // error
        if (status == "error") {
            // TODO
            alert("Error when loading data");
            return;
        }
        // success
        console.log(data);
        parseData(data);
        console.log(listAccount.AccountID);
        showAccount();
        totalPages = data.totalPages;
        pagingTable(totalPages);
    });
}

function pagingTable(pageAmount) {
    var pagingStr = "";
    // Hàm Gen nút Previous
    if (pageAmount > 1 && currentPage > 1) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="prevPaging()">Previous</a>' +
            '</li>';
    }
    // Hàm Gen nút số trang 1,2,3 ...
    for (i = 0; i < pageAmount; i++) {
        pagingStr +=
            '<li class="page-item ' + (currentPage == i + 1 ? "active" : "") + '">' +
            '<a class="page-link" onClick="changePage(' + (i + 1) + ')">' + (i + 1) + '</a>' +
            '</li>';
    }
    // Hàm Gen nút Next
    if (pageAmount > 1 && currentPage < pageAmount) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="nextPaging()">Next</a>' +
            '</li>';
    } $('#pagination').empty();
    $('#pagination').append(pagingStr);
}
function changePage(page) {
    if (page == currentPage) {
        return;
    }
    currentPage = page;
    getListEmployees();
}
// Hàm xử lý khi nhấn nút Previous
function prevPaging() {
    changePage(currentPage - 1);
}
// Hàm xử lý khi nhấn nút next
function nextPaging() {
    changePage(currentPage + 1);
}
function resetPaging() {
    currentPage = 1;
    size = 5;
}
function handleSearch() {
    getListEmployees();
    }