load("@rules_jvm_external//:defs.bzl", "artifact")

package(
   default_visibility = ["//src:__subpackages__"],
)

android_library(
    name = "greeter_activity",
    srcs = [
        "Greeter.java",
        "MainActivity.java",
    ],
    manifest = "AndroidManifest.xml",
    resource_files = glob(["res/**"]),
    deps = [
        artifact("com.google.android.material:material"),
        artifact("androidx.appcompat:appcompat"),
    ]
)