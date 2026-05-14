APPIUM 3 MOBILE TEST PROJECT

Modern Mobile Automation Stack (2026)

Bileşen	            Önerilen Sürüm              Neden
Java                JDK 17 LTS	                En yaygın stabil LTS
IntelliJ IDEA       2025.x Community/Ultimate	Appium + Maven için çok stabil
Node.js	            22 LTS	                    Modern Appium uyumu
Appium Server       3.4.x	                    Güncel mimari
Appium Java Client	10.x Maven dependency 	    Appium 3 uyumu
Selenium	        4.35+ Maven dependency 	    W3C standardı
Android Studio	    Panda / 2025.x	            Güncel SDK & emulator
Android SDK	        API 35 veya 36	            Modern Android testleri
UiAutomator2        Driver	6.x	                Android standardı
Maven	            3.9+                        Dependency yönetimi
Test Framework	    TestNG	                    Mobil projelerde çok yaygın


Android Studio Kurulum sırasında şunlar işaretli olsun:
• Android SDK
• Android SDK Platform
• Android Virtual Device (AVD)
• Android Emulator

Önerilen Emulator
Ayar	        Öneri
Device	        Pixel 6a
Android Version	Android 15
API Level	    35
Service			Google APIs
ABI	            x86_64
RAM	            default yeterli

Kurulumdan sonra ilk yapacağın şey:
SDK Manager

Daha sonra şunları kur:
SDK Platforms
• Android 15 (API 35)

SDK Tools
• Android SDK Build-Tools
• Android SDK Command-line Tools
• Android Emulator
• Platform Tools


Test edilecek demo uygulamanın adı ve adresi:
ApiDemos-debug_v6.0.10.apk
https://github.com/appium/android-apidemos/releases/download/v6.0.10/ApiDemos-debug.apk