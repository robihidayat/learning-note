## Standarisasi Pengujian Web vs API

pak rizky : 
curhat dan pengen tau, dari sisi qa kendalanya apa ? 
change failure, oco sama cm. ada perubahan dari sisi pihak ketiga, ternyaat di sisi kita belum berubah.
dependency testing... ?
scop dari testing ? 
harus bener2 berlanjut sampai production. 
techops cuma diakhir, techops bisa memberikan masukan dari awal sampai akhir. 
yang susah, perubahan di mva tapi impack di DW. 
riview jangan cuma di QA, tapi di techops juga.  


prant: 
perlu, mainset masing2. barang kali ada yang miss. biar lebih terbuka pemikirannya. nambah insigt. 
aware di awal, 
ketika deploy product, db lupa di update. 



mas surya: 
QC tau gak sistem dari flow nya ? agar awirness dari masing2 product. 

gom-gom: 
ini tentang technologi ? atau cara ?


dita:
standar tentang flow. standar yang harus di jalankan di setiap team. 

pak rizky: 
kaya apa aja yang harus di test.


fico:
flow sebelum masuk ke production.


mbak :
dod sudah di set di awal. dod.


pak rizky:
rollback testing. 


mas riza:
karakteristk di product beda2. dimulai dari karakter product. contoh di web, kapasitas di setiap browser. 

robi:
sequrity testing. 

quorum :
setuju ada standarisasi. 

mas opi:
managing people, with limited resource. 
testing dulu, baru coding. 

environment beda2. sehingga pada saat test di uat berhasil, pada saat di production gagal. 
workaround solution.
caos engineering. 

iats

cicd test painttest

sesi diskusi:
1. apa sih yang mesti kita test
2. x factor apa yang harus di test 


============

- api test :
    > validasi api 
    case nya len param, format, type dari request param. misal mandatory or optional. 
    > functionalitas

    > make sure ke db

    > dependency existing products

    > end to end sekenario test same flow. 

    > log monitoring 

============




tim jaya:
- param validation
- negative test
- kita gak tau apa yang terjadi
- db koneksi
- app koneksi, time out, 
- http vaidation
- konketen response
- performance test
- load test


tim dwike:
- function vs opration


tim grace:
- integration testing

tim mas arif:
- regrestion
- stress test
- performance test
- functional
- production
- rollback test
- ab testing
- uat




simpulan:
- param validation [1]
- app connection [5]
- http validation [3]
- content body [4]
- performance test [10]
- integration test [8]
- regretssion test [7]
- production test [] - ressilian test
- rollback test
- security test [9]
- functional test <+/-> [2]
- file validation < metadata, size, properties >
- db connection [6]




















