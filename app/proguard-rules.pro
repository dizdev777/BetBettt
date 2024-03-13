-optimizationpasses 65
-keepattributes Signature

-dontusemixedcaseclassnames
-keep class okhttp3.** { *; }
-keepclassmembers enum * { *; }
-keep class okio.** { *; }

-dontwarn com.google.errorprone.annotations.MustBeClosed

-dontskipnonpubliclibraryclasses
-dontoptimize
-dontpreverify

