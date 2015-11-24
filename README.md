# cordova-plugin-signal-strength

Apache Cordova Plugin to detect GSM Signal Strength

### Supported Platforms

* Android

### Installation

`$ cordova plugin add https://github.com/petervojtek/cordova-plugin-signal-strength.git`

### Usage

The API has only has method `window.SignalStrength.dbm(callback)` which returns signal strength in [dBm units](http://powerfulsignal.com/cell-signal-strength.aspx) (negative integer).
Example
```
window.SignalStrength.dbm(
  function(measuredDbm){
    console.log('current dBm is: '+measuredDbm)
  }
)
```

you receive `-1` as a result if the device is unable to measure dBm at the moment.

You should call the `window.SignalStrength.dbm` only after cordova platform is ready. 
Example in Ionic framework:

```
  $ionicPlatform.ready(function() {
    window.SignalStrength.dbm(function(db){console.log(db)})
  });
```

### Notes

* `window.SignalStrength` is undefined when testing your app on your PC while using `ionic serve`.

### How to Contribute

Use pull request.
