# pigeon_issue_example

Project to reproduce an ArgumentError with Flutter Pigeon.

## Getting Started

* Run the tests under `test/pigeon_test.dart` and check the exception.
* Run `flutter build ios` and check the build error

## Flutter issue

This is the issue opened on Flutter: https://github.com/flutter/flutter/issues/93464 

### Error Log

This is the error log I get:

```log
Invalid argument: Instance of 'MessageKey'

When the exception was thrown, this was the stack:
#0      StandardMessageCodec.writeValue (package:flutter/src/services/message_codecs.dart:426:7)
#1      _HostApiBridgeCodec.writeValue (package:pigeon_issue_example/host_api.dart:45:13)
#2      StandardMessageCodec.writeValue.<anonymous closure> (package:flutter/src/services/message_codecs.dart:422:9)
#3      _LinkedHashMapMixin.forEach (dart:collection-patch/compact_hash.dart:400:8)
#4      StandardMessageCodec.writeValue (package:flutter/src/services/message_codecs.dart:421:13)
#5      _HostApiBridgeCodec.writeValue (package:pigeon_issue_example/host_api.dart:45:13)
#6      StandardMessageCodec.writeValue.<anonymous closure> (package:flutter/src/services/message_codecs.dart:423:9)
#7      _LinkedHashMapMixin.forEach (dart:collection-patch/compact_hash.dart:400:8)
#8      StandardMessageCodec.writeValue (package:flutter/src/services/message_codecs.dart:421:13)
#9      _HostApiBridgeCodec.writeValue (package:pigeon_issue_example/host_api.dart:45:13)
#10     _HostApiBridgeCodec.writeValue (package:pigeon_issue_example/host_api.dart:42:7)
#11     StandardMessageCodec.writeValue (package:flutter/src/services/message_codecs.dart:416:9)
#12     _HostApiBridgeCodec.writeValue (package:pigeon_issue_example/host_api.dart:45:13)
#13     StandardMessageCodec.encodeMessage (package:flutter/src/services/message_codecs.dart:314:5)
#14     BasicMessageChannel.send (package:flutter/src/services/platform_channel.dart:56:71)
#15     HostApiBridge.sendMessage (package:pigeon_issue_example/host_api.dart:75:23)
#16     main.<anonymous closure> (file:///Users/your.name/mydev/pigeon_issue_sample/pigeon_issue_example/test/pigeon_test.dart:25:9)
#17     main.<anonymous closure> (file:///Users/your.name/mydev/pigeon_issue_sample/pigeon_issue_example/test/pigeon_test.dart:14:49)
#18     testWidgets.<anonymous closure>.<anonymous closure> (package:flutter_test/src/widget_tester.dart:176:29)
<asynchronous suspension>
<asynchronous suspension>
(elided one frame from package:stack_trace)
```

## iOS Issue

This is the issue opened on Flutter: https://github.com/flutter/flutter/issues/93525

### Build Log

This is the error in build log I get:

```log
Running "flutter pub get" in pigeon_issue_example...               720ms
Building com.example.pigeonIssueExample for device (ios-release)...
Signing iOS app for device deployment using developer identity: "Apple Development: gianlucaparadise@gmail.com
()"
Running Xcode build...                                                  
 └─Compiling, linking and signing...                         7.7s
Xcode build done.                                           46.1s
Failed to build iOS app
Error output from Xcode build:
↳
    2021-11-12 06:28:22.812 xcodebuild[70850:6765927] CFURLRequestSetHTTPCookieStorageAcceptPolicy_block_invoke: no
    longer implemented and should not be called
    ** BUILD FAILED **


Xcode's output:
↳
    In file included from
    /Users/your.name/mydev/pigeon_issue_example/ios/Runner/HostApi.m:3:
    /Users/your.name/mydev/pigeon_issue_example/ios/Runner/HostApi.h:21:53: error: type
    argument 'MessageKey *' (aka 'enum MessageKey *') is neither an Objective-C object nor a block type
    @property(nonatomic, strong, nullable) NSDictionary<MessageKey *, NSString *> * additionalProperties;
                                                        ^~~~~~~~~~~~
    1 error generated.
    note: Using new build system
    note: Building targets in parallel
    note: Planning build
    note: Constructing build description
```
