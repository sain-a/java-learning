//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9};
        ArrayUtils.printArray(arr);
        int max = ArrayUtils.getMax(arr);
        System.out.println("最大值：" + max);

        ArrayUtils.reverse(arr);
        ArrayUtils.printArray(arr);
    }
}