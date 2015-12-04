package io.mook.rafTrain;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RafOP {

	public static void main(String[] args) throws IOException {

		// ����File
		File demo = new File("demo");
		// ע����������ڴ���File��ʱ��û��ָ��·������ôĬ�������·���ģ�
		// ���������ǵ���Ŀ����Ŀ¼��
		if (!demo.exists())
			demo.mkdir();

		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}

		// ==================================================================

		// ʹ��RandomAccessFile�����ļ�
		RandomAccessFile raf = new RandomAccessFile(file, "rw");

		// ��֤��ǰָ���λ��
		System.out.println("һ��ʼָ���λ�á���>" + raf.getFilePointer());

		// ʹ��RandomAccessFile�ĺô�
		// �ϵ�������Ѹ�ף�����߳������ļ��Ĳ��֣�ÿ���������غ����Ժ���Ҫƴ����һ��
		// �������ʹ�õ���RandomAccessFile

		raf.write('A');// --->ֻд��һ���ֽ�,
		// �����п�������ֽھ��㹻��ʾһ���ַ��ˣ�����Ӣ���ַ�
		System.out.println("дһ���ֽں�ָ���λ�á���>" + raf.getFilePointer());

		// ==================================================================

		// java�ײ����д��һ��int���͵�����
		int i = 0x7fffffff;
		// ���Ĵ�д
		raf.write(i >>> 24);// д��8λ
		raf.write(i >>> 16);// д�ڶ�����8λ
		raf.write(i >>> 8);// д��������8λ
		raf.write(i);// Ĭ�Ͼ���дһ���ֽ�(�Ͱ�λ)
		// ����������ذ�һ��int���͵�����д���ļ�
		System.out.println("����д��һ��int�������ݺ�ָ���λ�á���>" + raf.getFilePointer());

		// ������ʵrafҲ�ṩ��ֱ��дint�ķ���
		// ����Ե㿪�鿴Դ�롪��>ʵ����Ҳ���������ǵĴ���ʽ��
		raf.writeInt(i);

		// ==================================================================

		// raf��ʵҲ����ֱ��дһ���ֽ�����
		String s = "��";
		// ���ַ���ת�����ֽ�����
		byte[] gbk_byte = s.getBytes("gbk");
		raf.write(gbk_byte);

		System.out.println("��ʱ�ļ��ĳ���(�ֽ���)����>" + raf.length());

		// ==================================================================

		// ���ļ�
		// ����Ҫ���ı����ǰ�ָ���Ƶ���ͷλ��
		raf.seek(0);

		// ==================================================================

		// һ���Զ�ȡ�����ļ����е����ݶ����ڴ浱�е��ֽ�������ȥ
		// �����ֽ�����
		byte[] buf = new byte[(int) raf.length()];
		raf.read(buf);

		System.out.println(Arrays.toString(buf));

		String str = new String(buf);
		System.out.println(str);

		for (byte b : buf) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}

		raf.close();

	}

}
