# Bazel Android Sample

Bazel is an open-source build and test tool that supports projects in multiple languages and builds outputs for multiple platforms. This is a minimal sample with ui and a test. 

> This sample is in Java :fire:

## Libraries
- material theme
- appcompat
- robolectric
- junit
- espresso

## Getting Started

In order to run this sample you will need `bazel` installed in your machine.

### Install `Bazel`
- visit [here](https://bazel.build/install) to install
- run `bazel --version` or `bazel version` to check if it installed correctly

### Validate Bazel Workspace

Run `bazel info workspace` to validate that the project is a valid bazel project.
If Bazel prints the path of the current directory, you're good to go! If the WORKSPACE file does not exist, you may see an error message like:
```
ERROR: The 'info' command is only supported from within a workspace.
```
### Android SDK Integration

Make sure thee android sdk path is in the public environment variables. If not assuming the SDK is installed to default locations, you can use the following commands to set the ANDROID_HOME variable:
 - Linux : run `export ANDROID_HOME=$HOME/Android/Sdk/`
 - mac : run `export ANDROID_HOME=$HOME/Library/Android/sdk`
 - windows 
   - command prompt (CMD) : run `set ANDROID_HOME=%LOCALAPPDATA%\Android\Sdk`
   - powershell : run `$env:ANDROID_HOME="$env:LOCALAPPDATA\Android\Sdk"`

### Building The Project
- run
    ```
    bazel build //src/main:app --verbose_failures --experimental_strict_java_deps=off
    ```
- output
    ```
    INFO: Build option --experimental_strict_java_deps has changed, discarding analysis cache.
    INFO: Analyzed target //src/main:app (0 packages loaded, 1664 targets configured).
    INFO: Found 1 target...
    Target //src/main:app up-to-date:
    bazel-bin/src/main/app_deploy.jar
    bazel-bin/src/main/app_unsigned.apk
    bazel-bin/src/main/app.apk
    INFO: Elapsed time: 31.834s, Critical Path: 28.76s
    INFO: 38 processes: 1 internal, 18 darwin-sandbox, 19 worker.
    INFO: Build completed successfully, 38 total actions
    ```

### Installing The App
> Ensure and android device or emulator is connected
- run
  ```
   bazel mobile-install //src/main:app --start_app --verbose_failures --experimental_strict_java_deps=off
  ```
- output
  ```
    INFO: Build options --define and --use_workers_with_dexbuilder have changed, discarding analysis cache.
    INFO: Analyzed target //src/main:app (0 packages loaded, 1651 targets configured).
    INFO: Found 1 target...
    INFO: From Installing //src/main:app:
    I1026 12:45:52.337327 4540569088 incremental_install.py:441] Updating 1 dex...
    I1026 12:45:52.609202 4540569088 incremental_install.py:504] Updating application resources...
    I1026 12:45:52.816073 4540569088 incremental_install.py:600] Updating 0 native libs...
    I1026 12:45:53.555282 4540569088 incremental_install.py:790] Starting application com.example.bazel
    Target //src/main:app up-to-date:
    bazel-bin/src/main/app_files/full_deploy_marker
    bazel-bin/src/main/app_files/deploy_info_incremental.deployinfo.pb
    INFO: Elapsed time: 28.387s, Critical Path: 23.39s
    INFO: 71 processes: 15 internal, 10 darwin-sandbox, 1 local, 45 worker.
    INFO: Build completed successfully, 71 total actions
  ```
- ui

| Android                                           |
|:----------------------------------------------------------------------|
| <img src="images/bazel.png" width="200" hspace="2" alt="android" /> |

## Running Tests
- run
  ```
  bazel test //src/test:test --verbose_failures --experimental_strict_java_deps=off  --test_output=errors
  ```
- output
  ```
    INFO: Analyzed target //src/test:test (96 packages loaded, 1662 targets configured).
    INFO: Found 1 test target...
    Target //src/test:test up-to-date:
    bazel-bin/src/test/test.jar
    bazel-bin/src/test/test
    INFO: Elapsed time: 199.361s, Critical Path: 50.11s
    INFO: 437 processes: 25 internal, 407 darwin-sandbox, 5 worker.
    INFO: Build completed successfully, 437 total actions
    //src/test:test                                                          PASSED in 12.4s

    Executed 1 out of 1 test: 1 test passes.
    INFO: Build completed successfully, 437 total actions
  ```

## Flags
Here are some of the flags used with `bazel build/run/test ` commands and what they do.
- `--start_app`
  - starts the mobile app after installing
- `--verbose_failures` 
  - in case of any failure during build print the stacktrace
- `--experimental_strict_java_deps=off`
  - build fails if any class access nested dependencies, this fixes `Using type a library from an indirect dependency` error.
- `--test_output=errors`
  - if there are any errors while running tests, print the stacktrace

## For More Info/Questions
- Link to the official documentation can be found [here](https://bazel.build/)
- You can also look at their repo [here](https://github.com/bazelbuild)
- Reach me on twitter [here](https://twitter.com/mambo_bryan)