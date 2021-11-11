import 'package:pigeon/pigeon.dart';

enum MessageKey {
  title,
  subtitle,
  description,
}

class Message {
  int? id;
  Map<MessageKey?, String?>? additionalProperties;
}

@HostApi()
abstract class HostApiBridge {
  void sendMessage(Message message);
}
