<h1>Checking Orientation Changes</h1>

```
TextView tv = (TextView)findViewById(R.id.tv1);

if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
  tv.setText("Portrait mode");
}
if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
  tv.setText("Landscape mode");
}
```
