$(function() {
  // 初始化表格
  initTable();
  // 绑定按钮事件
  bindBtnEvent();
});

function initTable() {
  // 服务请求地址
  var url = context + "/jsp/data.json";
  var options = {ordering: false};
  grid = new L.FlexGrid("hdfsTable", url);
  grid.init(options); //初始化datatable
}

function bindBtnEvent() {
  $(document).on("click", "#addBtn", function() {
    // 跳转到新增页面
    alert("跳转到新增页面");
  });
  
  $(document).on("click", "#delBtn", function() {
    var selected = $('input[type="checkbox"]:checked');
    if(selected.length == 0) {
      // 选中记录为空，弹框提示
      $.dialog({
        type : "alert",
        content : "请至少选择一条记录!"
      });
    } else {
      // 获取选中记录的ID
      var array = [];
      $.each(selected, function() {
        array.push($(this).val());
      });
      var ids = array.join(",");
      // 执行删除操作
      doRemove(ids);
    }
  })
}

function forRemove(id) {
  $.dialog({
    type: "confirm",
    content: "确认删除?",
    ok: function() {
      doRemove(id);
    },
    cancel: function() {}
  });
}

function forEdit(id) {
  // 跳转到编辑页面
  alert("跳转到编辑页面");
}

function doRemove(ids) {
  $.ajax({
    url: context + "/service/resource/auth/hdfs?ids=" + ids,
  })
  .done(function() {
    // 重新刷新
  });
}

// 渲染checkbox
function renderCheckbox(data) {
  return '<input type="checkbox" name="checkboxlist" value="' + data + '">';
}

// 渲染状态
function renderStatus(data) {
  return data === 'Y' ? "启用": "停用";
}

// 渲染rules列
function renderRules(data, type, full) {
    var array = [];
    for(var i = 0, len = data.length; i < len; i++) {
      var tmp = '<div class="rule">'
              + '【' + data[i].group + '】'
              + '【' + data[i].users.join("、") + '】'
              + '【' + convertAuthority(data[i].authority) + '】'
              + '</div>';
      array.push(tmp);
    }
    return array.join("");
}

var authorityMapping = {
  "r": "读",
  "w": "写"
}

// 将r、w转换成'读'、'写'
function convertAuthority(authority) {
  var result = [];
  for(var i = 0, len = authority.length; i < len; i++) {
    result.push(authorityMapping[authority[i]]);
  }
  return result.join("、");
}

// 渲染目录
function renderCategory(data) {
  var html = [];
  for(var i=0; i<data.length; i++) {
    html.push('<div class="category">' + data[i]);
  }
  return html.join(",</div>") + "</div>";
}

// 渲染操作列
function renderOperation(data) {
  var html = '<a class="link" onclick="forEdit(\'' + data + '\')">编辑</a>'
           + '<a class="link" onclick="forRemove(\'' + data + '\')">删除</a>';
  return html; 
}