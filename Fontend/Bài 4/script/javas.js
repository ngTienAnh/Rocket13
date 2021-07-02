/*var json;
var Dropdownlist = {
    "Dell": ["7710", "5510", "XPS"],
    "Apple": ["Iphone", "Ipad", "Macbook"],
    "Sam Sung": ["Galaxy Tab", "Note 10", "Galaxy Edge"]
}
var proclist = [];
function DataIntoDropList() {
    document.getElementById("Manufacturer_Select_id").innerHTML += "<option value = \"Apple\">Apple</option><option value = \"Dell\">Dell</option><option value = \"Sam Sung\">Sam Sung</option>";
}
function addtocart() {
    var namepro = document.getElementById("procname").value;
    var manupro = document.getElementById("Manufacturer_Select_id").value;
    var catepro = document.getElementById("proccate").value
    var pricepro = document.getElementById("procprice").value;
    var quanpro = document.getElementById("procquan").value;
    var totalpro = document.getElementById("proctotal").value;

    var proc = {
        P_namepro: namepro,
        p_manupro: manupro,
        p_catepro: catepro,
        p_pricepro: pricepro,
        p_quanpro: quanpro,
        p_totalpro: totalpro,
    }
    proclist.push(proc);
    json = JSON.stringify(proclist);
    localStorage.setItem('proclist', json);
    showlist();


}
function showlist() {
    proclist = JSON.parse(localStorage.getItem('proclist'));
    document.getElementById("tr_table").innerHTML =
        `<thead>
<tr>
    <th>No</th>
    <th>Product Name</th>
    <th>Manufacturer Name</th>
    <th>Category Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Edit</th>
    <th>Delete</th>
    
</tr> `
    for (var i = 0; i < proclist.length; i++) {
        var item = proclist[i]
        document.getElementById("tr_table").innerHTML +=
            `</tr> 
<td>${i + 1}</td>
<td>${item.P_namepro}</td>
<td>${item.p_manupro}</td>
<td>${item.p_catepro}</td>
<td>${item.p_pricepro}</td>
<td>${item.p_quanpro}</td>
<td>
    <input type="button" value="Edit" class="btn btn-danger navbar-btn" onclick="editProduct(${i})">
</td>
<td>
    <input type="button" value="Delete" class="btn btn-default" onclick="delProduct(${i})">
</td>
</tr> `
    }
}*/

var listAccount = [];

getListAccount();

$(function () {
    $('#btn_reset').click(function () {
        $('#emid').val("")
        $('#ememail').val("")
        $('#emusername').val("")
        $('#emfullname').val("")
        $('#department_Select_id').val("")
        $('#position_Select_id').val("")
        $('#emdate').val("")
    })

    $('#main_form_id').submit(function () {
        var e_mail = $('#ememail').val()
        var e_uname = $('#emusername').val()
        var e_fname = $('#emfullname').val()
        var e_dep = $('#department_Select_id').val()
        var e_pos = $('#position_Select_id').val()
        var e_date = $('#emdate').val()
        var account = {
            'Email': e_mail,
            'Username': e_uname,
            'FullName': e_fname,
            'Department': e_dep,
            'Position': e_pos,
            'CreateDate': e_date,
            // 'AccountID': e_id,
        }
        // listAccount.push(account);
        // showaccount();
        $.post("https://60d9bda35f7bf100175476ee.mockapi.io/api/test/Account", account,
            function (data, status) {
                if (status == "error") {
                    alert("đã gặp lỗi");
                    return;
                }
                getListAccount();
            });
        return false;
    })
});

function showaccount() {
    $('#tbody_tb').empty();
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
            <th><button type="button" class="btn btn-danger " onclick="deleteaccount(${index})">Delete</button></th>
            <th><button type="button" class="btn btn-default " onclick="editaccount(${index})">Edit</button></th>
        </tr>`)
    }
};
function deleteaccount(index) {
    var isdelete = confirm('bạn có muốn xóa không?')
    if (isdelete) {
        $.ajax({
            url: 'https://60d9bda35f7bf100175476ee.mockapi.io/api/test/Account/' + listAccount[index].AccountID,
            type: 'DELETE',
            success: function (result) {
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }
                getListAccount();
            }
        })
    } else return;
}
function editaccount(index) {
    indexx = index;
    $('#emid').val(listAccount[index].AccountID)
    $('#ememail').val(listAccount[index].Email)
    $('#emusername').val(listAccount[index].Username)
    $('#emfullname').val(listAccount[index].FullName)
    $('#department_Select_id').val(listAccount[index].Department)
    $('#position_Select_id').val(listAccount[index].Position)
    $('#emdate').val(listAccount[index].CreateDate)
    document.getElementById('emaid').focus();
}
function clickupdate(){
    var e_id = $('#emid').val()
    var e_mail = $('#ememail').val()
    var e_uname = $('#emusername').val()
    var e_fname = $('#emfullname').val()
    var e_dep = $('#department_Select_id').val()
    var e_pos =  $('#position_Select_id').val()
    var e_date = $('#emdate').val()

    var account = {
        'Username': e_mail,
        'FullName': e_uname,
        'Department': e_fname,
        'Position': e_dep,
        'CreateDate': e_pos,
        'AccountID': e_date,
    }
    $.ajax({
        url: 'https://60d9bda35f7bf100175476ee.mockapi.io/api/test/Account/' + e_id,
        type: 'PUT',
        data: account,
        success: function (result) {
            // error
            if (result == undefined || result == null) {
                alert("Error when loading data");
                return;
            }
            getListAccount();
            document.getElementById('tr_table');
        }
    });
}


function getListAccount() {
            $.get("https://60d9bda35f7bf100175476ee.mockapi.io/api/test/Account", function (data, status) {
                listAccount = [];
                if (status == "error") {
                    alert("đã gặp lỗi");
                    return;
                }
                data.forEach(function (item) {
                    var account = {
                        'AccountID': item.AccountID,
                        'Email': item.Email,
                        'Username': item.Username,
                        'FullName': item.FullName,
                        'Department': item.Department,
                        'Position': item.Position,
                        'CreateDate': item.CreateDate,
                    };
                    listAccount.push(account);
                });
                showaccount();
            });
        }
function parsedate(data) {
            data.forEach(function (item) {
                var account = {
                    'AccountID': item.AccountID,
                    'Email': item.Email,
                    'Username': item.Username,
                    'FullName': item.FullName,
                    'Department': item.Department,
                    'Position': item.Position,
                    'CreateDate': item.CreateDate,
                };
                listAccount.push(account);
            });
        }
function posListAccount() {

        }