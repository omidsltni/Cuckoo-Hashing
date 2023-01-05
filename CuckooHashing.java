import java.util.Hashtable;

public class CuckooHashing
{
    static int size = 11;
    static Hashtable<Integer, Integer> Table1 = new Hashtable<>(size);
    static Hashtable<Integer, Integer> Table2 = new Hashtable<>(size);


    public static void main(String[] args)
    {
        int[] num = new int[]{20, 50, 53, 75, 72};


        for (int i = 0; i < 5; i++) {
            System.out.println("values    H1(values)    H2(values)");
            System.out.println(num[i] + "        " + Hash1(num[i]) + "             " + Hash2(num[i]));
        }


        System.out.println();
        System.out.println();
        System.out.println("INSERTION:");
        for (int i = 0; i < 5; i++)
        {
            System.out.println("insertion of " + num[i]);
            Insertion(num[i]);
            System.out.println("Table1:  " + Table1);
            System.out.println("Table2:  " + Table2);
        }


        System.out.println();
        System.out.println();
        System.out.println("DELETING:");
        System.out.println("deleting 75:");
        Delete(75);
        System.out.println("Table1:  " + Table1);
        System.out.println("Table2:  " + Table2);

        System.out.println();
        System.out.println();
        System.out.println("SEARCHING:");
        System.out.println("searching for 73:");
        System.out.println(Belong(73));
        System.out.println("Table1:  " + Table1);
        System.out.println("Table2:  " + Table2);

        System.out.println("searching for 72:");
        System.out.println(Belong(72));
        System.out.println("Table1:  " + Table1);
        System.out.println("Table2:  " + Table2);
    }


    public static int Hash1(int K)
    {
        return K % 11;
    }


    public static int Hash2(int K)
    {
        return (int) ((Math.floor(K /11)) % 11);
    }

    public static void Insertion(int value)
    {
        int i = 1, pass = 1;
        int temp;

        while (i < 2 * size)
        {
            if (pass == 1)
            {
                if (!Table1.containsKey(Hash1(value)))
                {
                    Table1.put(Hash1(value), value);
                    break;
                }
                else
                {
                    temp = Table1.get(Hash1(value));
                    Table1.replace(Hash1(value), value);
                    value = temp;
                    pass = 2;
                }
            }
            else
            {
                if (!Table2.containsKey(Hash2(value)))
                {
                    Table2.put(Hash2(value), value);
                    break;
                }
                else
                {
                    temp = Table2.get(Hash2(value));
                    Table2.replace(Hash2(value), value);
                    value = temp;
                    pass = 1;
                }
            }
            i++;
        }
    }


    public static boolean Belong(int value)
    {
        return (Table2.containsKey(Hash2(value)) || Table1.containsKey(Hash1(value)));
    }


    public static void Delete(int value)
    {
        if (Table1.get(Hash1(value)) == value)
        {
            Table1.remove(Hash1(value));
        }
        else if (Table2.get(Hash2(value)) == value)
        {
            Table2.remove(Hash2(value));
        }
        else
        {
            System.exit(0);
        }
    }
}
