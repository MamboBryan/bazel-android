load("@build_bazel_rules_android//android:rules.bzl", "android_binary")

package(
   default_visibility = ["//visibility:public"],
)

android_binary(
    name = "app",
    manifest = "AndroidManifest.xml",
    deps = ["//src/main/java/com/example/bazel:greeter_activity"],
)