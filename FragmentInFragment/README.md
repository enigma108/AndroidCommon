<h1>Fragment inside another Fragment Example</h1>
<h3>Child Fragment inside Parent Fragment</h3>


  <b>MainActivity</b>
  ```
  ParentFragment pf = new ParentFragment();
  getSupportFragmentManager().beginTransaction().add(R.id.fragment_container1, pf).commit();
  ```
  <br/>
  <b>activity_main.xml</b>
  ```
  <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:tools="http://schemas.android.com/tools"
  android:id="@+id/fragment_container1"
  android:layout_width="match_parent"
  android:layout_height="match_parent">
  </FrameLayout>
  ```
  <br/>
  
  <b>ParentFragment</b>
  ```
  ChildFragment cf = new ChildFragment();
  getChildFragmentManager().beginTransaction().add(R.id.fragment_container, cf).commit();
  ```
  <br/>
  <b>parent_fragment.xml</b>
  ```
  <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
  android:id="@+id/fragment_container"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:orientation="vertical"
  android:background="#00FF00">
  </FrameLayout>
  ```
  <br/>
  <b>

