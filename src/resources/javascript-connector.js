var jsConnector = {
  sendResult: function(result) {
    document.getElementById('learningStatus').innerHTML = result;
    window.scrollTo(0,0);
  },

  setSpinnerOverlay: function () {
    document.getElementById('spinner-overlay').style.display = 'inherit';
  },

  unsetSpinnerOverlay: function () {
    document.getElementById('spinner-overlay').style.display = 'none';
  }
}

function getJsConnector() {
  return jsConnector;
}