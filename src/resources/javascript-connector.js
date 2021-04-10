var jsConnector = {
  sendResult: function(result) {
    document.getElementById('result').innerHTML = result;
    window.scrollTo(0,0);
  },

  sendExecutionTime: function (execTime) {
    document.getElementById('executionTime').innerText = execTime;
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