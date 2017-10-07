class StaticField {
static int i = 7;
public static void main(String[] args) {
StaticField obj = new StaticField();
obj.i++;
StaticField.i++;
obj.i++;
System.out.println(StaticField.i + " "+ obj.i);
}
}
