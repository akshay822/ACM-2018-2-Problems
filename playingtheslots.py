import math

def pairwise(iterable):
    "s -> (s0, s1), (s2, s3), (s4, s5), ..."
    a = iter(iterable)
    return zip(a, a)

points=[]
for i in range(int(input())):
    points += tuple(map(float, input().split()))

newpoints=pairwise(points)
newpoints = list(newpoints)

def rotatePolygon(polygon,theta):
    """Rotates the given polygon which consists of corners represented as (x,y),
    around the ORIGIN, clock-wise, theta degrees"""
    theta = math.radians(theta)
    rotatedPolygon = []
    for corner in polygon :
        rotatedPolygon.append((corner[0]*math.cos(theta)-corner[1]*math.sin(theta) , corner[0]*math.sin(theta)+corner[1]*math.cos(theta)))
    return rotatedPolygon

finalmaxdistances = []
for i in range(0,180):
    y = 0.0
    x = float(i)
    for j in range(0,50):

        degree = float(x+y)
        newpolygon = rotatePolygon(newpoints, degree)

        newdistances = []

        for i in range(len(newpolygon)-1):
            for j in range(i+1, len(newpolygon)):
                newdistances += [abs((newpolygon[i][1] - newpolygon[j][1]))]

        finalmaxdistances.append(max(newdistances))
        y += 0.02

print(min(finalmaxdistances))
