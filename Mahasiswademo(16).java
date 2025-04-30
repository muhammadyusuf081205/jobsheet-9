import java.util.Scanner;

class Mahasiswa_16 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackTugasMahasiswa stack = new StackTugasMahasiswa(5);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Tugas Terbawah");
            System.out.println("5. Melihat Daftar Tugas");
            System.out.println("6. Hitung Jumlah Tugas");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    Mahasiswa mhs = new Mahasiswa(nama, nim, kelas);
                    stack.push(mhs);
                    System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.nama);
                    break;

                case 2:
                    Mahasiswa dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Menilai tugas dari " + dinilai.nama);
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = scan.nextInt();
                        scan.nextLine();
                        dinilai.tugasDinilai(nilai);
                        System.out.println("Nilai Tugas " + dinilai.nama + " adalah " + dinilai.nilai);
                    }
                    break;

                case 3:
                    Mahasiswa lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Tugas teratas (terakhir dikumpulkan):");
                        System.out.printf("Nama: %s\nNIM: %s\nKelas: %s\n", lihat.nama, lihat.nim, lihat.kelas);
                        if (lihat.nilai != -1) {
                            System.out.println("Nilai: " + lihat.nilai);
                        } else {
                            System.out.println("Status: Belum dinilai");
                        }
                    }
                    break;

                case 4:
                    Mahasiswa pertama = stack.peekBottom();
                    if (pertama != null) {
                        System.out.println("Tugas terbawah (pertama dikumpulkan):");
                        System.out.printf("Nama: %s\nNIM: %s\nKelas: %s\n", pertama.nama, pertama.nim, pertama.kelas);
                        if (pertama.nilai != -1) {
                            System.out.println("Nilai: " + pertama.nilai);
                        } else {
                            System.out.println("Status: Belum dinilai");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nDaftar Tugas Mahasiswa:");
                    System.out.println("--------------------------------------------------");
                    System.out.printf("%-15s %-10s %-10s %s\n", "Nama", "NIM", "Kelas", "Status");
                    System.out.println("--------------------------------------------------");
                    stack.print();
                    System.out.println("--------------------------------------------------");
                    break;
                    
                case 6:
                    int jumlahTugas = stack.count();
                    System.out.println("\nInformasi Jumlah Tugas:");
                    System.out.println("--------------------------------------------------");
                    System.out.println("Jumlah tugas yang sudah dikumpulkan: " + jumlahTugas);
                    System.out.println("Kapasitas maksimum: " + stack.size);
                    System.out.println("Sisa kapasitas: " + (stack.size - jumlahTugas));
                    System.out.println("--------------------------------------------------");
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilih != 0);
        
        scan.close();
    }
}