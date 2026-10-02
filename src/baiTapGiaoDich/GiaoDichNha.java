package baiTapGiaoDich;
import java.time.LocalDate;
public class GiaoDichNha extends GiaoDich {
	private String loaiNha;
	private String diaChi;
	
	public GiaoDichNha(String maGiaoDich, LocalDate ngayGiaoDich,
			double donGia, double dienTich, String loaiNha, String diaChi) {
		super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}

	public String getLoaiNha() {
		return loaiNha;
	}

	public void setLoaiNha(String loaiNha) {
		this.loaiNha = loaiNha;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public double tinhThanhTien() {
		if("Cao Cap".equalsIgnoreCase(loaiNha)) {
			return getDienTich() * getDonGia();
		}
		else {
			return getDienTich() * getDonGia() * 0.9;
		}
	}
	@Override
	public void hienThiThongTin() {
		super.hienThiThongTin();
		System.out.printf(" | Loai nha: %-8s | Dia chi: %-20s | Thanh Tien: %,15.0f VND",
				loaiNha, diaChi, tinhThanhTien());
	}
}
