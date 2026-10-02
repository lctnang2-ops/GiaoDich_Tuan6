package baiTapGiaoDich;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<GiaoDich> danhSachGD = new ArrayList<>();

        // 1. Tạo sẵn 3 giao dịch đất
        danhSachGD.add(new GiaoDichDat("GD_D01", LocalDate.of(2013, 9, 15), 2000000, 100, "A"));
        danhSachGD.add(new GiaoDichDat("GD_D02", LocalDate.of(2013, 9, 20), 1500000, 80, "B"));
        danhSachGD.add(new GiaoDichDat("GD_D03", LocalDate.of(2013, 10, 5), 1200000, 120, "C"));

        // 2. Tạo sẵn 3 giao dịch nhà
        danhSachGD.add(new GiaoDichNha("GD_N01", LocalDate.of(2013, 9, 10), 5000000, 90, "cao cấp", "123 Lê Lợi, Q1"));
        danhSachGD.add(new GiaoDichNha("GD_N02", LocalDate.of(2013, 8, 25), 3000000, 70, "thường", "456 Nguyễn Huệ, Q1"));
        danhSachGD.add(new GiaoDichNha("GD_N03", LocalDate.of(2013, 9, 28), 4000000, 110, "thường", "789 Trần Hưng Đạo, Q5"));

        // A. Tính tổng số lượng cho từng loại giao dịch
        int soLuongDat = 0;
        int soLuongNha = 0;
        double tongThanhTienDat = 0;

        for (GiaoDich gd : danhSachGD) {
            if (gd instanceof GiaoDichDat) {
                soLuongDat++;
                tongThanhTienDat += gd.tinhThanhTien(); // Cộng dồn tiền đất
            } else if (gd instanceof GiaoDichNha) {
                soLuongNha++;
            }
        }

        System.out.println("=========================================================================");
        System.out.println("1. TỔNG SỐ LƯỢNG CHO TỪNG LOẠI GIAO DỊCH");
        System.out.println("=========================================================================");
        System.out.println("- Tổng số lượng giao dịch đất : " + soLuongDat + " giao dịch");
        System.out.println("- Tổng số lượng giao dịch nhà : " + soLuongNha + " giao dịch");

        // B. Tính trung bình thành tiền của giao dịch đất
        double trungBinhThanhTienDat = (soLuongDat > 0) ? tongThanhTienDat / soLuongDat : 0;
        System.out.println("\n=========================================================================");
        System.out.println("2. TRUNG BÌNH THÀNH TIỀN CỦA GIAO DỊCH ĐẤT");
        System.out.println("=========================================================================");
        System.out.printf("Trung bình thành tiền giao dịch đất: %,.2f VNĐ\n", trungBinhThanhTienDat);

        // C. Xuất ra các giao dịch của tháng 9 năm 2013
        System.out.println("\n=========================================================================");
        System.out.println("3. DANH SÁCH CÁC GIAO DỊCH TRONG THÁNG 9 NĂM 2013");
        System.out.println("=========================================================================");
        int countT9 = 0;
        for (GiaoDich gd : danhSachGD) {
            if (gd.getNgayGiaoDich().getYear() == 2013 && gd.getNgayGiaoDich().getMonthValue() == 9) {
                gd.hienThiThongTin();
                countT9++;
            }
        }
        if (countT9 == 0) {
            System.out.println("Không có giao dịch nào trong tháng 9/2013.");
        }
    }
}