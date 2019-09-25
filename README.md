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
    - การเปลี่ยน icon launcher
4. การใช้  Activity Class
ลิงค์ AppCompatActivity -> https://developer.android.com/reference/android/support/v7/app/AppCompatActivity
    - AppCompatActivity VS Activity
    - onCreate
    - onStart
    - onResume
    - onStop
    - onDestroy
    - onBackPressed
### ตัวอย่าง การใส่ icon back และ ใส่ title
```
getSupportActionBar().setDisplayHomeAsUpEnabled(true);
getSupportActionBar().setDisplayShowHomeEnabled(true);
getSupportActionBar().setTitle("Title Name");
```
เพิ่ม onSupportNavigateUp
```
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
```

    
#### ตัวย่าง 1 activity
```
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("DEMO_DEBUG","onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DEMO_DEBUG","onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("DEMO_DEBUG","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("DEMO_DEBUG","onStop");
    }

    @Override
    public void onBackPressed() {
        Log.i("DEMO_DEBUG","onBackPressed");
    }
```

#### ตัวอย่างที่ 2 onBackPressed
```
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("แจ้งเตือน")
                .setMessage("ยืนยันปิด?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        onBackPressed2();
                    }})
                .setNegativeButton(android.R.string.no, null).show();

        Log.i("DEMO_DEBUG","onBackPressed");
    }
```
เพิ่ม onBackPressed2
```
    private void onBackPressed2(){
        super.onBackPressed();
    }
```

#### ตัวอย่างที่ 3 onDestroy
```
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Log.i("DEMO_DEBUG","Number: "+(number++));
                runNumber();
            }
        };

        runNumber();
    }
```
เพิ่ม runNumber,stopNumber
```
    private void runNumber(){
        handler.postDelayed(runnable,1000);
    }
    private void stopNumber(){
        handler.removeCallbacks(runnable);
    }
```

เรียก stopNumber
```
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("DEMO_DEBUG","onDestroy");

        stopNumber();
    }
```

5. การสร้าง layout
อ่านเพิ่ม > https://developer.android.com/guide/topics/ui/declaring-layout#java ,
https://developer.android.com/training/multiscreen/screensizes
    - เพิ่มหลายภาษา
    - ใส่รูป
    - ใส่สี
    - ใส่ขนาด
6. การใช้ intent
อ่านเพิ่ม > https://developer.android.com/reference/android/content/Intent
    - การส่งตัวแปร
    - การใช้ Flags
7. การใช้ RecyclerView 
อ่านเพิ่ม -> https://developer.android.com/guide/topics/ui/layout/recyclerview
