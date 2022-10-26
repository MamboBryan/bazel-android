android_local_test(
    name = "test",
    custom_package = "com.example.bazel",
    srcs = [
        "java/com/example/bazel/MainTest.java",
        "java/com/example/bazel/DrawableMatcher.java", 
        "java/com/example/bazel/EspressoTestsMatchers.java"
        ],
    manifest = "AndroidManifest.xml",
    test_class ="com.example.bazel.MainTest",
    deps = [
        "//src/main/java/com/example/bazel:greeter_activity",
        "@maven//:androidx_test_ext_junit",
        "@maven//:androidx_test_espresso_espresso_core",
        "@maven//:org_robolectric_robolectric",
        "@maven//:org_robolectric_shadows_framework",
        "@robolectric//bazel:android-all"
    ],
)
