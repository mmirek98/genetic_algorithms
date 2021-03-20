var jsConnector = {
  sendResult: function(result) {
    document.getElementById('learningStatus').innerHTML = result;
    window.scrollTo(0,0);
  }
}

function getJsConnector() {
  return jsConnector;
}