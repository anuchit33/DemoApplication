# DemoApplication

### Android JAVA Basic
1. สร้างแอพ
2. สร้าง AVD
3. โครงสร้าง
    - Gradle Scripts
    - Application id
    - Version
    - Manifests
    - Java
    - resource
4. การใช้  Activity Class
    -  กด Run (AppCompatActivity)
    - ใช้  Activity Class
```
package com.theim.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

5. การสร้าง layout
6. การใช้ intent
7. การใช้ list view VS scrollview
8. การใช้ fragment
9. การต่อ api
