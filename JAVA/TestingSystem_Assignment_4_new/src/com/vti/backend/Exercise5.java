package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.CanBo;
import com.vti.entity.CanBo.GioiTinh;
import com.vti.entity.CongNhan;
import com.vti.entity.HighSchoolStudent;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;

public class Exercise5 {
	private Scanner scc;
	private ArrayList<CanBo> ListCanBo;

	public Exercise5() {
		this.scc = new Scanner(System.in);
		this.ListCanBo = new ArrayList<CanBo>();
	}

	public void menu() {
		while (true) {
			System.out.println("======================================================================");
			System.out.println("=================Lựa chọn chức năng bạn muốn sử dụng==================");
			System.out.println("=== 1. Thêm mới cán bộ.											   ===");
			System.out.println("=== 2. Tìm kiếm theo họ tên. 									   ===");
			System.out.println("=== 3. Hiện thị thông tin về danh sách các cán bộ. 				   ===");
			System.out.println("=== 4. Nhập vào tên của cán bộ và delete cán bộ đó 				   ===");
			System.out.println("=== 5. Thoát khỏi chương trình. 								   ===");
			System.out.println("======================================================================");

			Scanner sc = new Scanner(System.in);
			int menuChoose = sc.nextInt();
			switch (menuChoose) {
			case 1:
				ThemCanBo();
				break;
			case 2:
				TimCanBo();
				break;
			case 3:
				DSCanBo();
				break;
			case 4:
				XoaCanBo();
				break;
			case 5:
				return;
			default:
				System.out.println("Lựa chọn đúng số trên menu");
				break;
			}
		}
	}

	public CanBo NhapCanBo(CanBo cb) {
		// Scanner scc = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập thông tin:");
		System.out.println("\tHọ tên: ");
		String ten = sc.nextLine();
		cb.setHoTen(ten);
		System.out.println("\tTuổi: ");
		cb.setTuoi(sc.nextInt());
		int gioiTinh = 0;
		System.out.println("\tĐịa chỉ: ");
		cb.setDiaChi(sc.next());
		do {
			System.out.println("\tGiới tính 1.Nam,2.Nữ,3.Khác ");
			switch (sc.nextInt()) {
			case 1:
				cb.setGioiTinh(GioiTinh.Nam);
				break;
			case 2:
				cb.setGioiTinh(GioiTinh.Nu);
				break;
			case 3:
				cb.setGioiTinh(GioiTinh.Khac);
				break;
			}
		} while (gioiTinh < 0 || gioiTinh > 4);
		return cb;
	}

	public void ThemCanBo() {
		CanBo cb = new CanBo();
		Scanner sc = new Scanner(System.in);
		System.out.println("Thêm: 1.Công nhân 2.Kỹ sư 3.Nhân viên");
		int t = sc.nextInt();
		switch (t) {
		case 1:
			System.out.println("Thêm Công nhân");
			NhapCanBo(cb);
			System.out.println("\tNhập cấp bậc: ");
			int CapBac = sc.nextInt();
			CanBo cn = new CongNhan(cb.getHoTen(), cb.getTuoi(), cb.getGioiTinh(), cb.getDiaChi(), CapBac);
			ListCanBo.add(cn);
			System.out.println("Thêm thành công");
			System.out.println(cn);
			break;
		case 2:
			System.out.println("Thêm kỹ sư");
			NhapCanBo(cb);
			System.out.println("\tNhập Ngành đào tạo: ");
			String NganhDT = sc.next();
			CanBo ks = new KySu(cb.getHoTen(), cb.getTuoi(), cb.getGioiTinh(), cb.getDiaChi(), NganhDT);
			ListCanBo.add(ks);
			System.out.println("Thêm thành công");
			System.out.println(ks);
			break;
		case 3:
			System.out.println("Thêm kỹ sư");
			NhapCanBo(cb);
			System.out.println("\tNhập Ngành đào tạo: ");
			String congViec = sc.next();
			CanBo nv = new NhanVien(cb.getHoTen(), cb.getTuoi(), cb.getGioiTinh(), cb.getDiaChi(), congViec);
			ListCanBo.add(nv);
			System.out.println("Thêm thành công");
			System.out.println(nv);
			break;
		}
	}

	private void XoaCanBo() {
		// TODO Auto-generated method stub
		System.out.println("Mời nhập tên cần xóa: ");
		String Name = scc.next();
		/*for (CanBo cb : ListCanBo) {
			if (cb.getHoTen().equals(Name)) {
				System.out.println("\tđã xóa: ");
				System.out.print(cb);
				ListCanBo.remove(cb);
			}
		}*/
		ListCanBo.removeIf(CanBo -> CanBo.getHoTen().equals(Name));
		DSCanBo();
	}

	private void DSCanBo() {
		// TODO Auto-generated method stub
		for (CanBo cb : ListCanBo) {
			System.out.println(cb);
		}
	}

	private void TimCanBo() {
		// TODO Auto-generated method stub
		System.out.println("Mời nhập tên cần tìm: ");
		String Name = scc.next();
		for (CanBo cb : ListCanBo) {
			if (cb.getHoTen().equals(Name)) {
				System.out.println(cb);
			}
		}
	}
	private void Ques3() {
		HighSchoolStudent hs = new HighSchoolStudent("Nam", 1, "Chuyên văn vở", "Mở hà nội");
	}
}
