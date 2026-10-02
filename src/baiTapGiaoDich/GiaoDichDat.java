package baiTapGiaoDich;
import java.time.LocalDate;
public class GiaoDichDat extends GiaoDich{
	private String loaiDat;
	
	public GiaoDichDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, 
						double dienTich, String loaiDat) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
	}

	public String getLoaiDat() {
		return loaiDat;
	}

	public void setLoaiDat(String loaiDat) {
		this.loaiDat = loaiDat;
	}
	@Override
	public double tinhThanhTien() {
		if("A".equalsIgnoreCase(loaiDat)) {
			return getDienTich() * getDonGia() * 1.5;
		}
		else {
			return getDienTich()*getDonGia();
		}
	}
	@Override
	public void hienThiThongTin() {
		super.hienThiThongTin();
		System.out.printf("| Loại đất: %-2s | Thành tiền: %,15.0f VNĐ\n", loaiDat, tinhThanhTien());
	}
}
