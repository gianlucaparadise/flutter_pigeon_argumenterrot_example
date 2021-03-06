// Autogenerated from Pigeon (v1.0.10), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.example.pigeon_issue_example;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class HostApi {

  public enum MessageKey {
    title(0),
    subtitle(1),
    description(2);

    private int index;
    private MessageKey(final int index) {
      this.index = index;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class Message {
    private Long id;
    public Long getId() { return id; }
    public void setId(Long setterArg) { this.id = setterArg; }

    private Map<MessageKey, String> additionalProperties;
    public Map<MessageKey, String> getAdditionalProperties() { return additionalProperties; }
    public void setAdditionalProperties(Map<MessageKey, String> setterArg) { this.additionalProperties = setterArg; }

    Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("id", id);
      toMapResult.put("additionalProperties", additionalProperties);
      return toMapResult;
    }
    static Message fromMap(Map<String, Object> map) {
      Message fromMapResult = new Message();
      Object id = map.get("id");
      fromMapResult.id = (id == null) ? null : ((id instanceof Integer) ? (Integer)id : (Long)id);
      Object additionalProperties = map.get("additionalProperties");
      fromMapResult.additionalProperties = (Map<MessageKey, String>)additionalProperties;
      return fromMapResult;
    }
  }
  private static class HostApiBridgeCodec extends StandardMessageCodec {
    public static final HostApiBridgeCodec INSTANCE = new HostApiBridgeCodec();
    private HostApiBridgeCodec() {}
    @Override
    protected Object readValueOfType(byte type, ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return Message.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(ByteArrayOutputStream stream, Object value)     {
      if (value instanceof Message) {
        stream.write(128);
        writeValue(stream, ((Message) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter.*/
  public interface HostApiBridge {
    void sendMessage(Message message);

    /** The codec used by HostApiBridge. */
    static MessageCodec<Object> getCodec() {
      return HostApiBridgeCodec.INSTANCE;
    }

    /** Sets up an instance of `HostApiBridge` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, HostApiBridge api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.HostApiBridge.sendMessage", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              Message messageArg = (Message)args.get(0);
              if (messageArg == null) {
                throw new NullPointerException("messageArg unexpectedly null.");
              }
              api.sendMessage(messageArg);
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  private static Map<String, Object> wrapError(Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", null);
    return errorMap;
  }
}
