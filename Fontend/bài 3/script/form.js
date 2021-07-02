var json ;
var Dropdownlist = {
    "Dell": ["7710", "5510", "XPS"],
    "Apple": ["Iphone", "Ipad", "Macbook"],
    "Sam Sung": ["Galaxy Tab", "Note 10", "Galaxy Edge"]
}
var proclist =[];
function DataIntoDropList(){
    document.getElementById("Manufacturer_Select_id").innerHTML += "<option value = \"Apple\">Apple</option><option value = \"Dell\">Dell</option><option value = \"Sam Sung\">Sam Sung</option>";
}
function addtocart(){
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
    localStorage.setItem('proclist',json);
    showlist();

    
}
function showlist(){
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
    for (var i= 0 ; i < proclist.length; i++) {
        var item = proclist[i]
        document.getElementById("tr_table").innerHTML +=
   `</tr> 
   <td>${i+1}</td>
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
}