import demo.User;
import demo.UserForm;
import org.apache.commons.codec.binary.Hex;

public class TestProto {

    public static void main(String[] args) {

        print(User.newBuilder().build());

        print(User.newBuilder()
                .setName("")
                .build());

        print(User.newBuilder()
                .setField(User.getDescriptor().findFieldByNumber(User.NAME_FIELD_NUMBER), "")
                .build());

        print(User.newBuilder()
                .setName("a")
                .build());

        //User.newBuilder().def

        System.out.println("------------------------------------------------------------");

        print(UserForm.newBuilder().build());

        print(UserForm.newBuilder()
                .setName("")
                .build());

        print(UserForm.newBuilder()
                .setUid(0)
                .build());

        print(UserForm.newBuilder()
                .setGender(false)
                .build());

        print(UserForm.newBuilder()
                .setGender(true)
                .build());
    }

    private static void print(User user) {
        System.out.println(hex(user.toByteArray()) + " // " + user.hasField(User.getDescriptor().findFieldByNumber(User.NAME_FIELD_NUMBER)));
    }
    private static void print(UserForm user) {
        System.out.println(hex(user.toByteArray()) + " // " + user.getFieldCase().getNumber());
    }
    private static String hex(byte[] bytes) {
        return Hex.encodeHexString(bytes);
    }

}
