function SignalStrength() {
  this.dbm = function(callback) {
    return cordova.exec(callback, function(err) {
      callback(-1);
    }, "SignalStrength", "dbm", []);

  };
}

window.SignalStrength = new SignalStrength()
