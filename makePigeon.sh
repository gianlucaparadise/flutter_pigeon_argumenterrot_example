flutter pub run pigeon \
--input pigeon/host_api_definitions.dart \
--dart_out lib/host_api.dart \
--objc_header_out ios/Classes/HostApi.h \
--objc_source_out ios/Classes/HostApi.m \
--java_out ./android/app/src/main/java/com/example/pigeon_issue_example/HostApi.java \
--java_package "com.example.pigeon_issue_example"