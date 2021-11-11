import 'package:flutter_test/flutter_test.dart';
import 'package:pigeon_issue_example/host_api.dart';

void main() {
  testWidgets("should send message without enums", (WidgetTester tester) async {
    final api = HostApiBridge();

    Message message = Message()
      ..id = 1
      ..additionalProperties = {};

    api.sendMessage(message);
  });
  testWidgets("should send message with enums", (WidgetTester tester) async {
    final api = HostApiBridge();

    Message message = Message()
      ..id = 1
      ..additionalProperties = {
        MessageKey.title: "title",
        MessageKey.subtitle: "subtitle",
        MessageKey.description: "description",
      };

    api.sendMessage(message);
  });
}
