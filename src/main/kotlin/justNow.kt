import kotlin.random.Random
import kotlin.random.nextInt

val timeInSite =
    Random.nextInt(0..300_000)        //��� �������� ������ ������������ ����� ������������ ��������� �����

val secondsToMinutes: Int = timeInSite / 60
val minutesToHours: Int = secondsToMinutes / 60
//val hoursToDays: Int = minutesToHours / 24        //��������, ���� ���� ���������� ����

fun timeWithOne(): Boolean = (secondsToMinutes == 1 || secondsToMinutes % 10 == 1 && secondsToMinutes % 100 != 11) ||
        (minutesToHours == 1 || minutesToHours % 10 == 1 && minutesToHours % 100 != 11)

fun timeWithTwoThreeFour(): Boolean = (timeInSite < 5 && timeInSite != 0 ||
        timeInSite % 10 == 2 && timeInSite != 12 ||
        timeInSite % 10 == 3 && timeInSite != 13 ||
        timeInSite % 10 == 4 && timeInSite != 14) ||
        (minutesToHours < 5 && minutesToHours != 0 ||
                minutesToHours % 10 == 2 && minutesToHours != 12 ||
                minutesToHours % 10 == 3 && minutesToHours != 13 ||
                minutesToHours % 10 == 4 && minutesToHours != 14)

fun timeToMinute(): String =
    if (timeWithOne()) "$secondsToMinutes ������ �����"
    else if (timeWithTwoThreeFour()) "$secondsToMinutes ������ �����"
    else "$secondsToMinutes ����� �����"

fun timeToHour(): String =
    if (timeWithOne()) "$minutesToHours ��� �����"
    else if (timeWithTwoThreeFour()) "$minutesToHours ���� �����"
    else "$minutesToHours ����� �����"

fun agoToText(): String {
    val allTime = when (timeInSite) {
        in 0..60 -> "���(-�) �� ����� ������ ���"
        in 61..3_600 -> "���(-�) �� ����� ${timeToMinute()}"
        in 3_601..86_400 -> "���(-�) �� ����� ${timeToHour()}"
        in 86_401..172_800 -> "���(-�) �� ����� �������"
        in 172_801..259_200 -> "���(-�) �� ����� �����"
        else -> "���(-�) �� ����� �����"
    }
    return allTime
}

fun main() {
    print(agoToText())
}